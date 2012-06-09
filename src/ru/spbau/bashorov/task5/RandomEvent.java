package ru.spbau.bashorov.task5;

import java.util.Random;

/**
 * RandomEvent ready for action if random integer is even
 *
 * @author Zalim Bashorov
 */
public class RandomEvent extends Event{
    private static Random random = new Random();

    /**
     * @return random ready state
     */
    @Override
    public boolean ready() {
        return random.nextBoolean();
    }

}
