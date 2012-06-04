package ru.spbau.bashorov.task4;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 3/20/12
 * Time: 4:19 PM
 */
public class HeapSort implements Sorter {
    /**
     * Sorts the list of comparable type.
     *
     * @param list - the sort list
     */
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, new Comparator<T>() {
            @Override
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
        if (l < size && comparator.compare(list.get(l), list.get(i)) == 1) {
            great = l;
        }

        if (r < size && comparator.compare(list.get(r), list.get(great)) == 1) {
            great = r;
        }

        if (great != i) {
            Collections.swap(list, i, great);
            heapify(list, great, size, comparator);
        }
    }
}
