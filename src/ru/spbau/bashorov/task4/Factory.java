package ru.spbau.bashorov.task4;

/**
 * Interface for simple Factory.
 * Provides the ability to create objects of type {@code T}.
 * @param <T> type of return object.
 * @author Zalim Bashorov
 */
public interface Factory<T> {
    /**
     * Create objects of type {@code T}.
     * @return new object instance of {@code T} type.
     */
    T create();
}
