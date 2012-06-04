package ru.spbau.bashorov.task4;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 3/20/12
 * Time: 4:09 PM
 */
public class ComparableInteger implements Comparable<ComparableInteger> {
    final Integer value;

    public ComparableInteger(int value) {
        this.value = value;
    }

    public ComparableInteger mod(int n) {
        return new ComparableInteger(value / n);
    }

    @Override
    public int compareTo(ComparableInteger x) {
        return value.compareTo(x.value);
    }
}
