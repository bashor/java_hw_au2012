package ru.spbau.bashorov.task5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create RandomEvent and TimeEvent Objects, add ActionListener Objects to events, process the events
 * @author Zalim Bashorov
 */
public class Main {
    /**
     * Entry point
     * @param args no used
     */
    public static void main(String[] args) {
        RandomEvent randomEvent = new RandomEvent();

        // Create RandomEvent listeners
        for (int i = 0; i < 5; i++) {
            final int index = i;
            randomEvent.addListener(new ActionListener() {
                @Override
                public void performAction(Event event) {
                    System.out.println("RandomEvent #" + index);
                }
            });

            randomEvent.addListener(new ActionListener() {
                @Override
                public void performAction(Event event) {
                    System.out.println("Creating RandomEvent time " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            });
        }

        TimeEvent timeEvent = new TimeEvent();

        // Create TimeEvent listeners
        for (int i = 0; i < 5; i++) {
            final int index = i;

            timeEvent.addListener(new ActionListener() {
                @Override
                public void performAction(Event event) {
                    System.out.println("TimeEvent #" + index);
                }
            });

            timeEvent.addListener(new ActionListener() {
                private String date = new Date().toString();

                @Override
                public void performAction(Event event) {
                    System.out.println("Creating TimeEvent time " + date);
                }
            });
        }

        // process events
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
                break;
            }

            if (randomEvent.ready())
                randomEvent.fireEvent();

            if (timeEvent.ready())
                timeEvent.fireEvent();
        }
    }
}
