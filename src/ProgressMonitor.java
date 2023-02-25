public class ProgressMonitor implements Runnable {
    StringBuilder[] printSlots;
    int maxThreads;

    public ProgressMonitor(int maxThreads) {
        printSlots = new StringBuilder[maxThreads];
        this.maxThreads = maxThreads;
    }

    public synchronized int findSlot() {
        int slot = -1;
        for (int x = 0; x < maxThreads; x++) {
            if (printSlots[x] == null) {
                printSlots[x] = new StringBuilder();
                slot = x;
                break;
            }
        }
        return slot;
    }

    public synchronized void done(int slot) {
        printSlots[slot] = null;
    }

    public synchronized StringBuilder getStringBuilder(int slot) {
        return printSlots[slot];
    }

    private int charToInt(char c) {
        int v = 0;
        switch (c) {
            case '1':
                v = 0;
                break;
            case '2':
                v = 1;
                break;
            case '3':
                v = 2;
                break;
            case '4':
                v = 3;
                break;
        }
        return v;
    }

    private float percentage(String states) {
        int quadValue = 0;
        if (states.length() > 20) {
            int startsAt = states.indexOf(":") + 8;
            String substring = states.substring(startsAt, startsAt + 5);
            char[] chars = substring.toCharArray();
            int s0 = charToInt(chars[4]);
            int s1 = charToInt(chars[3]);
            int s2 = charToInt(chars[2]);
            int s3 = charToInt(chars[1]);
            int s4 = charToInt(chars[0]);
            quadValue = s0 + 4 * s1 + 16 * s2 + 64 * s3 + 256 * s4;
        }
        return quadValue * 100 / 1024.0F;
    }

    private String percentageString(String states) {
        float percentage = percentage(states);
        return String.format(" %4.1f%% ", percentage);
    }

    private int getHighPercentIndex() {
        float high = 0f;
        int highIndex = 0;
        for (int slot = 0; slot < maxThreads; slot++) {
            if (printSlots[slot] != null && printSlots[slot].length() > 20) {
                float c = percentage(printSlots[slot].toString());
                if (c > high) {
                    high = c;
                    highIndex = slot;
                }
            }
        }
        return highIndex;
    }

    public void run() {
        StringBuilder line = new StringBuilder();
        try {
            while (true) {
                synchronized(this) {
                    this.wait();
                }
                int highIndex = getHighPercentIndex();
                System.out.print("\033[0;0H"); // cursor to top-left
                for (int slot = 0; slot < maxThreads; slot++) {
                    line.setLength(0);
                    line.append(String.format("%4d  ", slot));
                    if (printSlots[slot] != null) {
                        if (highIndex == slot) {
                            line.append("\033[1m");
                        }
                        line.append(percentageString(printSlots[slot].toString()));
                        if (highIndex == slot) {
                            line.append("\033[0m");
                        }
                        line.append(" ");
                        line.append(printSlots[slot].toString());
                    } else {
                        line.append("\033[K"); // clear to end of line
                    }
                    System.out.println(line);
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e);
            System.exit(1);
        }
        System.out.println();
    }
}
