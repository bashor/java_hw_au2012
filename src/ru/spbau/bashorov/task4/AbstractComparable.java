package ru.spbau.bashorov.task4;

/**
 * This class provides a skeletal implementation of the <tt>Comparable</tt> interface.
 *
 * @param <T> the type of value
 *
 * @author Zalim Bashorov
 */
public class AbstractComparable<T extends java.lang.Comparable<T>> implements Comparable<AbstractComparable<T>> {
    private final T value;

    /**
     * Initializes a newly created object.
     * @param value assign to object value field
     */
    public AbstractComparable(final T value) {
        this.value = value;
    }

    /**
     * Getter for value field
     * @return value
     */
    public T getValue() {
        return value;
    }

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
    @Override
    public int compareTo(final AbstractComparable<T> x) {
        return value.compareTo(x.value);
    }
}