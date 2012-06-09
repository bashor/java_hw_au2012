package ru.spbau.bashorov.task4;

import java.util.List;

/**
 * Interface for sorting algorithms.
 * @author Zalim Bashorov
 */
public interface Sorter {
    /**
     * Sorts the {@code List<T>}.
     * @param <T> comparable type
     * @param list the sort list
     */
    public <T extends Comparable<? super T>> void sort(List<T> list);

    /**
     * Sorts the {@code List<T>}.
     * @param list the sort list
     * @param comparator comparator providing comparing
     */
    public <T> void sort(List<T> list, Comparator<T> comparator);
}
