package ru.spbau.bashorov.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 6/5/12
 * Time: 7:13 AM
 *
 * Base class for events
 */
public abstract class Event {
    final private List<ActionListener> listeners = new ArrayList<ActionListener>();

    /**
     * Get the event ready status
     * @return ready status
     */
    public abstract boolean ready();

    /**
     * Perform action for all listeners
     */
    protected void fireEvent() {
        for (ActionListener listener : listeners) {
            listener.performAction(this);
        }
    }

    /**
     * Add(subscribe to event) new listener
     * @param actionListener - new listener
     */
    public void addListener(ActionListener actionListener) {
        if (actionListener != null)
            listeners.add(actionListener);
    }
}
