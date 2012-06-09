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

    public Task(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int res){
        result = res;
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }
}