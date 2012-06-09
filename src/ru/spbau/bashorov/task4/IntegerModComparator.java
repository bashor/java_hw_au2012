package ru.spbau.bashorov.task4;

/**
 * Comparing by mod
 * @author Zalim Bashorov
 */

public class IntegerModComparator implements Comparator<ComparableInteger> {
    private final int n;

    /**
     * Create new instance with mod value
     * @param n mod value
     */
    public IntegerModComparator(int n) {
        this.n = n;
    }

    /**
     * Compare two objects by mod value
     * @param  x the first object to compare
     * @param  y the second object to compare
     * @return the value {@code 0} if {@code x % n == y % n };
     *         a value less than {@code 0} if {@code x % n < y % n}; and
     *         a value greater than {@code 0} if {@code x % n > y % n}
     */
    @Override
    public int compare(ComparableInteger x, ComparableInteger y) {
        return (new Integer(x.getValue() % n)).compareTo(y.getValue() % n);
    }
}
