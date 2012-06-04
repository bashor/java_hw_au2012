package ru.spbau.bashorov.task4;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 3/20/12
 * Time: 4:18 PM
 */
public class ShakerSort implements Sorter {

    /**
     * Sorts the list of comparable type.
     *
     * @param list - the sort list
     */
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, new Comparator<T>() {
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            }
        });
    }

    /**
     * Sorts the list of comparable type.
     *
     * @param list       - the sort list
     * @param comparator - comparator providing comparing
     */
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        int begin = 0;
        int end = list.size() - 1;

        int p = 1;

        boolean swapped;
        do {
            swapped = false;
            for (int i = begin; i != end; ) {
                int j = i + p;
                if (comparator.compare(list.get(i), list.get(j)) == p) {
                    Collections.swap(list, i, j);
                    swapped = true;
                }
                i = j;
            }

            p *= -1;
            end += p;

            int t = begin;
            begin = end;
            end = t;
        } while (swapped);
    }
}
