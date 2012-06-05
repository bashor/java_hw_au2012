package ru.spbau.bashorov.task7;

import java.util.Queue;
import java.util.Random;

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
     * Start work
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

            synchronized (task) { //Synchronization on local variable 'task'???
                try {
                    Thread.sleep(50 + new Random().nextInt(100));
                } catch (InterruptedException e) {
                    synchronized (queue) {
                        queue.add(task);
                        queue.notifyAll();
                    }
                    continue;
                }
                task.setResult(task.value + 1);
                task.notify();
            }
        }
    }
}