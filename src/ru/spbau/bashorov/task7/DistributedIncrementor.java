package ru.spbau.bashorov.task7;

import java.util.LinkedList;
import java.util.Queue;

public class DistributedIncrementor {
    private final Queue<Task> queue = new LinkedList<>();

    /**
     * Increment value one
     *
     * @param value to increment
     * @return value + 1
     * @throws InterruptedException if interrupted
     */
    public int increment(int value) throws InterruptedException {
        final Task task = new Task(value); //Synchronization on local variable 'task'???

        synchronized (queue) {
            queue.add(task);
            queue.notifyAll();
        }

        synchronized (task) {
            while (!task.isDone) {
                task.wait();
            }
        }

        return task.result;
    }

    public DistributedIncrementor(int workerCount) {
        for (int i = 0; i < workerCount; i++) {
            new Worker(queue);
        }
    }
}