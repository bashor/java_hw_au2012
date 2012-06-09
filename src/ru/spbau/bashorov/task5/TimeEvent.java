package ru.spbau.bashorov.task5;

/**
 * Time event -- ready for action every 10 secs after last fire
 *
 * @author Zalim Bashorov
 */
public class TimeEvent extends Event {
    private static final int TIME_AFTER_RESTORE_READY = 10000;
    private long lastFireTime = System.currentTimeMillis();

    public void fireEvent() {
        lastFireTime = System.currentTimeMillis();
        super.fireEvent();
    }

    /**
     * @return true ready state If after last event has been more than 10 sec
     */
    @Override
    public boolean ready() {
        return System.currentTimeMillis() - lastFireTime >= TIME_AFTER_RESTORE_READY;
    }
}
