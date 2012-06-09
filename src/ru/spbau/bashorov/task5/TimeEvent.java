package ru.spbau.bashorov.task5;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Time event -- ready for action every 10 secs
 *
 * @author Zalim Bashorov
 */
public class TimeEvent extends Event {
    private static final int TIME_AFTER_RESTORE_READY = 10000;

    private long lastFireTime;

    public void fireEvent() {
        lastFireTime = System.currentTimeMillis();
        super.fireEvent();
    }

    @Override
    public boolean ready() {
        return System.currentTimeMillis() - lastFireTime >= TIME_AFTER_RESTORE_READY;
    }
}
