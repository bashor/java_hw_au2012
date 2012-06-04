package ru.spbau.bashorov.task4;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 3/20/12
 * Time: 4:12 PM
 */

public class IntegerModComparator implements Comparator<ComparableInteger> {
    final int n;

    public IntegerModComparator(int n) {
        this.n = n;
    }

    @Override
    public int compare(ComparableInteger x, ComparableInteger y) {
        return x.mod(n).compareTo(y.mod(n));
    }
}
