package ru.spbau.bashorov.task4;

import java.util.List;

/**
 * This class provides a skeletal implementation of the <tt>Sorter</tt> interface.
 * @author Zalim Bashorov
 */
abstract public class SorterBase implements Sorter{
    /**
     * Sorts the {@code List<T>}.
     * @param <T> comparable type
     * @param list the sort list
     */
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, new Comparator<T>() {
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            }
        });
    }
}