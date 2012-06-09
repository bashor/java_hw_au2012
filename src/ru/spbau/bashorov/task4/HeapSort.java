package ru.spbau.bashorov.task4;

import java.util.Collections;
import java.util.List;

/***
 * The implementation of the algorithm HeapSort
 * @author Zalim Bashorov
 */
public class HeapSort extends SorterBase {
    /**
     * Sorts the {@code List<T>}.
     * @param list the sort list
     * @param comparator comparator providing comparing
     */
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        int size = list.size();

        // make heap
        for (int i = (size - 1) / 2; i >= 0; i--) {
            heapify(list, i, size, comparator);
        }

        // sorting
        for (int i = size; i > 0; i--) {
            Collections.swap(list, 0, size - 1);
            size--;
            heapify(list, 0, size, comparator);
        }
    }

    static private int left(int i) {
        return (2 * i) + 1;
    }

    static private int right(int i) {
        return (2 * i) + 2;
    }

    static private <T> void heapify(List<T> list, int i, int size, Comparator<T> comparator) {
        int l = left(i);
        int r = right(i);

        int great = i;
        if (l < size && comparator.compare(list.get(l), list.get(i)) > 0) {
            great = l;
        }

        if (r < size && comparator.compare(list.get(r), list.get(great)) > 0) {
            great = r;
        }

        if (great != i) {
            Collections.swap(list, i, great);
            heapify(list, great, size, comparator);
        }
    }
}
