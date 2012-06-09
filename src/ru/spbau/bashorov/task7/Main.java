package ru.spbau.bashorov.task7;

/**
 * Multithreaded computing
 * @author Zalim Bashorov
 */
public class Main {
    private static final int WORKER_COUNT = 5;
    private static final int CLIENT_COUNT = 5;
    private static final int NUMBERS_COUNT = 10;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 1000;

    /**
     * Entry point
     * @param args not used
     */
    public static void main(String args[]) {
        DistributedIncrementor di = new DistributedIncrementor(WORKER_COUNT);
        for (int i = 0; i < CLIENT_COUNT; i++) {
            new StupidChild(di, i, NUMBERS_COUNT, RANDOM_MIN, RANDOM_MAX);
        }
    }

}