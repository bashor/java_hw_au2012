package ru.spbau.bashorov.task6;

/**
 * An IllegalSerializationException is thrown when an application have critical problem with serialization/deserialization object.
 */
public class IllegalSerializationException extends ReflectiveOperationException {
    /**
     * Create new IllegalSerializationException object with parameter.
     * @param message for detail information about thrown exception.
     */
    public IllegalSerializationException(String message) {
        super(message);
    }
}
