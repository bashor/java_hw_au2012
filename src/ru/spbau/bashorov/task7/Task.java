package ru.spbau.bashorov.task7;

/**
 * Task for Workers
 *
 * @author Zalim Bashorov
 */
public class Task {
    private final int value;
    private int result;
    private boolean isDone = false;

    /**
     * Construct new Task
     * @param value task data
     */
    public Task(int value){
        this.value = value;
    }

    /**
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return result value
     */
    public int getResult() {
        return result;
    }

    /**
     * Set result value and change done state to true
     * @param res set value
     */
    public void setResult(int res){
        result = res;
        isDone = true;
    }

    /**
     * @return done state
     */
    public boolean isDone() {
        return isDone;
    }
}