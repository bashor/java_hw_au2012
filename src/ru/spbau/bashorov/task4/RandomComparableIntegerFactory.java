package ru.spbau.bashorov.task4;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 6/5/12
 * Time: 1:35 AM
 */
public class RandomComparableIntegerFactory implements Factory<ComparableInteger> {
    private Random random = new Random();

    @Override
    public ComparableInteger create() {
        return new ComparableInteger(random.nextInt());
    }
}
