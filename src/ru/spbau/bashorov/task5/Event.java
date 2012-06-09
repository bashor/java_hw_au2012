package ru.spbau.bashorov.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for events
 *
 * @author Zalim Bashorov
 */
public abstract class Event {
    private final List<ActionListener> listeners = new ArrayList<>();

    /**
     * Get the event ready status
     * @return ready status
     */
    public abstract boolean ready();

    /**
     * Perform action for all listeners
     */
    public void fireEvent() {
        for (ActionListener listener : listeners) {
            listener.performAction(this);
        }
    }

    /**
     * Add(subscribe to event) new listener
     * @param actionListener - new listener
     *
     * @exception IllegalArgumentException when actionListener is null
     */
    public void addListener(ActionListener actionListener) {
        if (actionListener != null)
            throw new IllegalArgumentException("actionListener is null");

        listeners.add(actionListener);
    }
}
