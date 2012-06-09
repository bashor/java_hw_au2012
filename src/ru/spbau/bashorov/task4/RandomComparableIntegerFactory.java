package ru.spbau.bashorov.task4;

import java.util.Random;

/**
 * Factory of ComparableInteger objects with random Integer value
 * @author Zalim Bashorov
 */
public class RandomComparableIntegerFactory implements Factory<ComparableInteger> {
    private static final Random random = new Random();

    /**
     * @return new ComparableInteger object with random Integer value
     */
    @Override
    public ComparableInteger create() {
        return new ComparableInteger(random.nextInt());
    }
}
