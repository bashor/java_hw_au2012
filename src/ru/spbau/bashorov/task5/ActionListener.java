package ru.spbau.bashorov.task5;

/**
 * The listener interface for receiving action events.
 * @author Zalim Bashorov
 */
public interface ActionListener {
    /**
     * Invoked when an action occurs.
     * @param event which occurred
     */
    void performAction(Event event);
}
