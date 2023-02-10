//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class StatePuzzle {
    public StatePuzzle() {
    }

    public static void main(String[] args) {
        int maxThreads = 4;
        int startingThread = 0;

        if (args.length > 0) {
            if (("?".compareTo(args[0]) == 0) || ("h".compareTo(args[0]) == 0)) {
                printHelpMessage();
            } else {
                maxThreads = Integer.parseInt(args[0]);
            }
        }
        if (args.length > 1) {
            startingThread = Integer.parseInt(args[1]);
        }

        System.out.print("\033c\033[" + (maxThreads + 2) + ";0H");
        System.out.println("maxThreads: " + maxThreads);
        System.out.println("startingThread: " + startingThread);
        System.out.println();

        StatePuzzle statePuzzle = new StatePuzzle();
        statePuzzle.solve(maxThreads, startingThread);
        System.exit(0);
    }

    private static void printHelpMessage() {
        System.out.println("Usage: [maxThreads] [startingThread]");
        System.out.println("defaults: 4 0");
    }

    private void solve(int maxThreads, int startingThread) {
        Object monitor = new Object();
        ProgressMonitor progressMonitor = new ProgressMonitor(maxThreads);
        HashSet<Integer> skipThread = new HashSet<>();

        try {

            (new Thread(progressMonitor)).start();

            int threadsRunning;
            for(threadsRunning = startingThread; threadsRunning < 4096; ++threadsRunning) {
                getThreadsToSkip(skipThread);
                if (!skipThread.contains(threadsRunning)) {
                    StateInfo[] stateInfo = StateInfo.stateInfoFactory();
                    StateMap map = new StateMap(threadsRunning, stateInfo, maxThreads, monitor, progressMonitor);
                    (new Thread(map)).start();
                    Thread.sleep(100L);

                    while(maxThreads <= StateMap.getNumberOfThreadsRunning()) {
                        synchronized (monitor) {
                            monitor.wait();
                        }
                    }
                }
            }

            int prevThreadsRunning = -1;

            while((threadsRunning = StateMap.getNumberOfThreadsRunning()) > 0) {
                if (prevThreadsRunning != threadsRunning) {
                    //System.out.println("Threads running = " + threadsRunning);
                    prevThreadsRunning = threadsRunning;
                }

                synchronized(monitor) {
                    monitor.wait();
                }
            }

            System.out.println("Total solutions found: " + StateMap.getNumberOfSolutions());
        } catch (InterruptedException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
    }

    private void getThreadsToSkip(HashSet<Integer> skipThread) {
        String fileName = System.getProperty("user.home") + "/solutions/lastjob.trk";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                skipThread.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
        }
    }
}