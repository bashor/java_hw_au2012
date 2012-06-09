package ru.spbau.bashorov.task4;

/**
 * Provides interface for comparable objects
 *
 * @param <T> the type of compared objects
 *
 * @author Zalim Bashorov
 */
public interface Comparable<T> {
    /**
     * Compares the current(this) object with object from param
     *
     * @param x the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this object.
     */
    int compareTo(T x);
}
