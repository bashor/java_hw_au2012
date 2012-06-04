package ru.spbau.bashorov.task4;

public class ComparableString implements Comparable<ComparableString> {
    final String value;

    public ComparableString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(ComparableString x) {
        return value.compareTo(x.value);
    }
}
