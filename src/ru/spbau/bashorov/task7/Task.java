package ru.spbau.bashorov.task7;

/**
 * Task for Workers
 */
public class Task {
    public final int value;
    public int result;
    public boolean isDone = false;

    public Task(int value){
        this.value = value;
    }

    public void setResult(int res){
        result = res;
        isDone = true;
    }
}