package ru.spbau.bashorov.task4;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    static public <T extends Comparable<? super T>> void run(int n, Factory<T> factory, Comparator<T> comparator, Sorter... sorters) {
        List<T> list1 = new ArrayList<T>();
        List<T> list2 = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            T t = factory.create();
            list1.add(t);
            list2.add(t);
        }

        for (Sorter sorter : sorters) {
            System.out.printf("%s:\n\t%d elements\t without comparator sorted \t %d msec\n",
                    sorter.getClass().getSimpleName(), n, getTime(list1, sorter));
            System.out.printf("\t%d elements\t with comparator sorted \t %d msec\n",
                    n, getTime(list2, sorter, comparator));
        }
    }

    static public <T extends Comparable<? super T>> long getTime(List<T> list, Sorter sorter) {
        long startTime = System.currentTimeMillis();
        sorter.sort(list);
        return System.currentTimeMillis() - startTime;
    }

    static public <T> long getTime(List<T> list, Sorter sorter, Comparator<T> comparator) {
        long startTime = System.currentTimeMillis();
        sorter.sort(list, comparator);
        return System.currentTimeMillis() - startTime;
    }
}
