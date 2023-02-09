public class ProgressMonitor implements Runnable {
    StringBuilder[] printSlots;
    int maxThreads;
    static String blankLine = " ".repeat(66);

    public ProgressMonitor(int maxThreads) {
        printSlots = new StringBuilder[maxThreads];
        this.maxThreads = maxThreads;
    }

    public synchronized int findSlot() {
        int slot;
        for (slot = 0; slot < maxThreads; slot++) {
            if (printSlots[slot] == null) {
                printSlots[slot] = new StringBuilder();
                break;
            }
        }
        printSlots[slot] = new StringBuilder();
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

    private String percentage(String states) {
        String answer = "";
        if (states.length() > 20) {
            int startsAt = states.indexOf(":") + 8;
            String substring = states.substring(startsAt, startsAt + 5);
            char[] chars = substring.toCharArray();
            int s0 = charToInt(chars[4]);
            int s1 = charToInt(chars[3]);
            int s2 = charToInt(chars[2]);
            int s3 = charToInt(chars[1]);
            int s4 = charToInt(chars[0]);
            int quadValue = s0 + 4*s1 + 16*s2 + 64*s3 + 256*s4;
            float percent = quadValue * 100 / 1024.0F;
            answer = String.format(" %4.1f%% ", percent);
        }
        return answer;
    }

    public void run() {
        StringBuilder line = new StringBuilder();
        try {
            while (true) {
                synchronized(this) {
                    this.wait();
                }
                System.out.print("\033[0;0H");
                for (int slot = 0; slot < maxThreads; slot++) {
                    line.setLength(0);
                    line.append(String.format("%4d  ", slot));
                    if (printSlots[slot] != null) {
                        line.append(percentage(printSlots[slot].toString()));
                        line.append(" ");
                        line.append(printSlots[slot].toString());
                    } else {
                        line.append(blankLine);
                    }
                    System.out.println(line);
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
        System.out.println();
    }
}
