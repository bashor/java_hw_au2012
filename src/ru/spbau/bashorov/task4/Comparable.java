package ru.spbau.bashorov.task4;

/**
 * Privides interface for comparable objects
 */
public interface Comparable<T> {
    /**
     * Compares the current(this) object with object from param
     *
     * @param x - the passed object
     * @return 1 if this object greater then x,
     *         0 if this object equal to x,
     *         -1 if this object lesser then x,
     */
    int compareTo(T x);
}
