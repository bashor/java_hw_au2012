package ru.spbau.bashorov.task4;

/**
 * Comparing by string length
 * @author Zalim Bashorov
 */
public class StringLengthComparator implements Comparator<ComparableString> {
    /**
     * Compare two {@code String} by length
     * @param  x the first object to compare
     * @param  y the second object to compare
     * @return the value {@code 0} if {@code x.length() == y.length()};
     *         a value less than {@code 0} if {@code x.length() < y.length()}; and
     *         a value greater than {@code 0} if {@code x.length() > y.length()}
     */
    @Override
    public int compare(ComparableString x, ComparableString y) {
        return x.getValue().length() - y.getValue().length();
    }
}
