package ru.spbau.bashorov.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Test class, which can measure execution time of different sorters and different comparators.
 * @author Zalim Bashorov
 */

public class Tester {
    /**
     * Running the test
     * @param n Size of test input for sort algorithms.
     * @param factory comparable object factory.
     * @param comparator <T> compare strategy, used by sorting algorithm.
     * @param sorters implementations of sort algorithms
     * @param <T> type of sorting objects(is {@code Comparable})
     */
    public static <T extends Comparable<? super T>> void run(int n, Factory<T> factory, Comparator<T> comparator, Sorter... sorters) {
        List<T> list = generateTestData(n, factory);

        String elementClassName = factory.create().getClass().getSimpleName();

        for (Sorter sorter : sorters) {
            System.out.printf("%s, %d elements of type %s\n\twithout comparator sorted \t %d msec\n",
                    sorter.getClass().getSimpleName(), n, elementClassName,
                    getTime(new ArrayList<T>(list), sorter));

            System.out.printf("\twith comparator sorted \t\t %d msec\n",
                    getTime(new ArrayList<T>(list), sorter, comparator));
        }
    }

    /**
     * Measures sorting time of list with given sorter.
     * @param list list to sort
     * @param sorter sort algorithm implementation.
     * @param <T> type of sorting objects
     * @return time of execution in milliseconds.
     */
    static public <T extends Comparable<? super T>> long getTime(List<T> list, Sorter sorter) {
        long startTime = System.currentTimeMillis();
        sorter.sort(list);
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Measures sorting time of list with given sorter and comparator.
     * @param list list to sort
     * @param sorter sort algorithm implementation.
     * @param comparator used by sorting algorithm.
     * @param <T> type of sorting objects
     * @return time of execution in milliseconds.
     */
    static public <T> long getTime(List<T> list, Sorter sorter, Comparator<T> comparator) {
        long startTime = System.currentTimeMillis();
        sorter.sort(list, comparator);
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Generates list of n {@code Comparable} elements.
     * @param n Size of generated list.
     * @param factory Comparable object factory
     * @return List of n random comparable objects.
     */
    private static <T extends Comparable<? super T>> List<T> generateTestData(int n, Factory<T> factory) {
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            T t = factory.create();
            list.add(t);
        }

        return Collections.unmodifiableList(list);
    }
}
