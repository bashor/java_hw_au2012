package ru.spbau.bashorov.task4;

/**
 * Provides interface for compare some objects
 * @param <T> the type of compared objects
 *
 * @author Zalim Bashorov
 */
public interface Comparator<T> {
    /**
     * Compares two {@code T} objects.
     *
     * @param  x the first object to compare
     * @param  y the second object to compare
     * @return the value {@code 0} if {@code x == y};
     *         a value less than {@code 0} if {@code x < y}; and
     *         a value greater than {@code 0} if {@code x > y}
     */
    int compare(T x, T y);
}
