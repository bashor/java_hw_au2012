package ru.spbau.bashorov.task7;

import java.util.Queue;
import java.util.Random;

/**
 * A Worker which processes tasks
 * @author Zalim Bashorov
 */
public class Worker extends Thread {
    private final Queue<Task> queue;

    /**
     * Construct and start worker
     * @param queue with tasks
     */
    public Worker(Queue<Task> queue) {
        this.queue = queue;
        setDaemon(true);
        start();
    }

    /**
     * Start work.
     * Ignores the interrupt request.
     */
    public void run() {
        while (!Thread.interrupted()) {
            Task task = null;
            synchronized (queue) {
                try {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                } catch(InterruptedException e) {
                    continue;
                }
                task = queue.poll();
            }

            synchronized (task) {
                try {
                    Thread.sleep(50 + new Random().nextInt(100));
                } catch (InterruptedException e) {
                    synchronized (queue) {
                        queue.add(task);
                        queue.notify();
                    }
                    continue;
                }
                task.setResult(task.getValue() + 1);
                task.notify();
            }
        }
    }
}