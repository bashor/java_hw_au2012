package ru.spbau.bashorov.task4;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 6/5/12
 * Time: 1:39 AM
 */
public class RandomComparableStringFactory implements Factory<ComparableString> {
    private Random random = new Random();

    @Override
    public ComparableString create() {
        byte[] b = new byte[random.nextInt(333)];
        random.nextBytes(b);

        return new ComparableString(new String(b));
    }
}
