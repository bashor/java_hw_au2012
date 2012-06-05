package ru.spbau.bashorov.task5;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 6/5/12
 * Time: 7:18 AM
 *
 * Time event -- ready for action every 10 secs
 */
public class TimeEvent extends Event {
    public static final int TIME_AFTER_RESTORE_READY = 10000;

    private boolean ready = false;
    private Timer timer = new Timer(true);

    /**
     * Create new TimeEvent which ready for action every 10 secs
     */
    public TimeEvent(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ready = true;
            }
        }, TIME_AFTER_RESTORE_READY);
    }

    public void fireEvent() {
        ready = false;
        super.fireEvent();
    }

    @Override
    public boolean ready() {
        return ready;
    }
}
