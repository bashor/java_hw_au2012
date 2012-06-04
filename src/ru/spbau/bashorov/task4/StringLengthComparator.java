package ru.spbau.bashorov.task4;

public class StringLengthComparator implements Comparator<ComparableString> {
    @Override
    public int compare(ComparableString x, ComparableString y) {
        int xLength = x.getValue().length();
        int yLength = y.getValue().length();

        if (xLength > yLength)
            return 1;
        if (xLength < yLength)
            return -1;
        return 0;
    }
}
