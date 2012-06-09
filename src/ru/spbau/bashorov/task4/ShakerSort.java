package ru.spbau.bashorov.task4;

import java.util.Collections;
import java.util.List;

/**
 * The implementation of the algorithm HeapSort ShakerSort
 * @author Zalim Bashorov
 */
public class ShakerSort extends SorterBase {
    /**
     * Sorts the {@code List<T>}.
     * @param list the sort list
     * @param comparator comparator providing comparing
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
                if (signof(comparator.compare(list.get(i), list.get(j))) == p) {
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

    private int signof(int value) {
        return value > 0 ? 1 : value < 0 ? -1 : 0;
    }
}
