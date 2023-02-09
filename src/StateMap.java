//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;

public class StateMap implements Runnable {
    private final Object monitor;
    private static int threadsRunning;
    private static int numberOfSolutions;
    private final int[] mapColors = new int[48];
    private final String home;
    private final StateInfo[] stateInfo;
    private final int threadNumber;
    private final StringBuilder path;
    private int maxThreads;
    private HiLoScore hiLoScore;
    private int solutionCount;
    private int slot;
    ProgressMonitor progressMonitor;

    public StateMap(int threadNumber, StateInfo[] stateInfo, int maxThreads, Object monitor, ProgressMonitor progressMonitor) {
        this.monitor = monitor;
        this.maxThreads = maxThreads;
        this.threadNumber = threadNumber;
        this.mapColors[0] = threadNumber / 1024;
        threadNumber -= this.mapColors[0] * 1024;
        this.mapColors[1] = threadNumber / 256;
        threadNumber -= this.mapColors[1] * 256;
        this.mapColors[2] = threadNumber / 64;
        threadNumber -= this.mapColors[2] * 64;
        this.mapColors[3] = threadNumber / 16;
        threadNumber -= this.mapColors[3] * 16;
        this.mapColors[4] = threadNumber / 4;
        threadNumber -= this.mapColors[4] * 4;
        this.mapColors[5] = threadNumber;
        this.mapColors[0]++;
        this.mapColors[1]++;
        this.mapColors[2]++;
        this.mapColors[3]++;
        this.mapColors[4]++;
        this.mapColors[5]++;
        this.stateInfo = stateInfo;
        this.home = System.getProperty("user.home");
        numberOfSolutions = 0;
        this.path = new StringBuilder(100);
        this.progressMonitor = progressMonitor;
        slot = progressMonitor.findSlot();
        hiLoScore = new HiLoScore();
    }

    static synchronized int getNumberOfThreadsRunning() {
        return threadsRunning;
    }

    static synchronized int getNumberOfSolutions() {
        return numberOfSolutions;
    }

    synchronized void printThreadStarted() {
        System.out.println("Started Thread" + this.threadNumber);
    }

    public void run() {
        int thread = this.threadNumber;
        this.incrementThreadCount();
        // this.printThreadStarted();
        this.generateSolutions(6);
        progressMonitor.done(slot);
        this.decrementThreadCount();
        WriteThreadNumber(thread);
    }

    private synchronized void incrementNumberOfSolutions() {
        ++numberOfSolutions;
    }

    private void incrementThreadCount() {
        synchronized(this.monitor) {
            ++threadsRunning;
            this.monitor.notifyAll();
        }
    }

    private synchronized void decrementThreadCount() {
        synchronized(this.monitor) {
            --threadsRunning;
            this.monitor.notifyAll();
        }
    }

    private synchronized void printSolutionToScreen() {
        if (--solutionCount <= 0) {
            solutionCount = 10000000;
            StringBuilder sb = progressMonitor.getStringBuilder(slot);
            sb.setLength(0);
            sb.append(String.format("%4d", threadNumber)).append(": ");
            for (int i = 0; i < 48; i++) {
                sb.append(mapColors[i]);
            }
            synchronized (progressMonitor) {
                progressMonitor.notifyAll();
            }
        }
    }

    private void generateSolutions(int state) {
        if (state == 48) {
            this.writeSolution();
            this.printSolutionToScreen();
            this.incrementNumberOfSolutions();
        } else {
            for(int c = 1; c <= 4; ++c) {
                this.mapColors[state] = c;
                if (!this.touching(state)) {
                    this.generateSolutions(state + 1);
                }
            }

            this.mapColors[state] = 0;
        }
    }

    private boolean touching(int state) {
        for(int boarderState = this.stateInfo[state].getBorder(); boarderState >= 0; boarderState = this.stateInfo[state].getNextBorder()) {
            if (this.mapColors[boarderState] == this.mapColors[state]) {
                return true;
            }
        }

        return false;
    }

    private String createName(int attempt) {
        this.path.setLength(0);
        this.path.append(this.home);
        this.path.append(File.separator);
        this.path.append("solutions");
        this.path.append(File.separator);
        this.path.append(Integer.toString(this.score()));
        if (attempt > 0) {
            this.path.append("-");
            this.path.append(String.format("%04d", attempt));
        }
        this.path.append(".txt");
        return this.path.toString();

    }

    private synchronized void WriteThreadNumber(int thread) {
        String fileName = this.home + File.separator + "solutions" + File.separator + "lastthread.txt";
        try {
            Files.writeString(
                    Path.of(fileName),
                    Integer.toString(thread) + System.lineSeparator(),
                    CREATE, APPEND
            );
        } catch (IOException e) {
            System.err.println("Can't write " + fileName);
            System.err.println(e.toString());
        }
    }

    private synchronized void writeSolution() {
        if (!hiLoScore.setIsWithin(this.score())) {
            String pathString = createName(0);
            File f = new File(pathString);
            if (!f.exists()) {
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(pathString));
                    Throwable except = null;

                    try {
                        for (int x = 0; x < 48; ++x) {
                            br.write(StateNames.getName(x) + ":" + this.getColorText(this.mapColors[x]));
                            br.newLine();
                        }
                    } catch (Throwable e) {
                        except = e;
                        throw e;
                    } finally {
                        if (except != null) {
                            try {
                                br.close();
                            } catch (Throwable e) {
                                except.addSuppressed(e);
                            }
                        } else {
                            br.close();
                        }
                    }
                } catch (StateNameError | IOException var16) {
                    Logger.getLogger(StateMap.class.getName()).log(Level.SEVERE, (String) null, var16);
                }
            }
        }
    }

    private int score() {
        int score = 0;

        for(int state = 0; state < 48; ++state) {
            score += this.stateInfo[state].getArea() * this.mapColors[state];
        }

        return score;
    }

    private String getColorText(int mapColor) {
        String color;
        switch (mapColor) {
            case 1:
                color = "red";
                break;
            case 2:
                color = "blue";
                break;
            case 3:
                color = "green";
                break;
            case 4:
                color = "yellow";
                break;
            default:
                color = "ERROR";
        }

        return color;
    }
}