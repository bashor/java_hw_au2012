package ru.spbau.bashorov.task4;

import java.util.Random;

/**
 * Factory of ComparableString objects with random String value
 * @author Zalim Bashorov
 */
public class RandomComparableStringFactory implements Factory<ComparableString> {
    private static final int MAX_RANDOM_LENGTH = 300;
    private static final Random random = new Random();

    /**
     * @return new ComparableInteger object with random String value
     */
    @Override
    public ComparableString create() {
        byte[] b = new byte[random.nextInt(MAX_RANDOM_LENGTH)];
        random.nextBytes(b);

        return new ComparableString(new String(b));
    }
}
