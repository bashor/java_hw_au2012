package ru.spbau.bashorov.task7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Provide incrementing services use some workers
 * @author Zalim Bashorov
 */
public class DistributedIncrementor {
    private final Queue<Task> queue = new LinkedList<>();

    /**
     * Increment value
     * @param value to increment
     * @return incremented value
     * @throws InterruptedException if interrupted
     */
    public int increment(int value) throws InterruptedException {
        final Task task = new Task(value);

        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }

        synchronized (task) {
            while (!task.isDone()) {
                task.wait();
            }
        }

        return task.getResult();
    }

    /**
     * Construct new incrementing service provider({@code DistributedIncrementor}) with {@code workerCount} workers
     * @param workerCount workers count
     */
    public DistributedIncrementor(int workerCount) {
        for (int i = 0; i < workerCount; i++) {
            new Worker(queue);
        }
    }
}