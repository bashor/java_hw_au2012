package ru.spbau.bashorov.task7;

import java.util.Random;

/**
 * Client of DistributedIncrementor(Incrementing service)
 * @author Zalim Bashorov
 */
public class StupidChild extends Thread {

    private int[] numbers;
    private int id;
    private DistributedIncrementor incrementor;

    /**
     * Constructor with constraints
     * @param incrementor  link to service
     * @param id of the thread
     * @param numbersCount count for generated numbers
     * @param randomMin minimum value for generated numbers
     * @param randomMax maximum value for generated numbers
     */
    public StupidChild(DistributedIncrementor incrementor, int id, int numbersCount, int randomMin, int randomMax) {
        if (randomMin > randomMax) {
            int t = randomMin;
            randomMin = randomMax;
            randomMax = t;
        }

        this.id = id;
        this.incrementor = incrementor;

        numbers = new int[numbersCount];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randomMin + rand.nextInt(randomMax - randomMin);
        }

        start();
    }

    /**
     * Generate numbers and asks DistributedIncrementor to increment
     */
    public void run() {
        System.out.println("StupidChild " + id + " is started");
        boolean interrupted = false;

        for (int n : numbers) {
            if (interrupted = Thread.interrupted())
                break;

            int after;
            try {
                Thread.sleep(10);
                after = incrementor.increment(n);
            } catch (InterruptedException e) {
                interrupted = true;
                break;
            }

            Thread.yield();

            System.out.printf("[%d]\t%d\t->\t%d\n", id, n, after);
        }
        System.out.println("StupidChild " + id + " is " + (interrupted ? "interrupted" : "finished"));
   }

}