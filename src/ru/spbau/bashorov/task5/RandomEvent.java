package ru.spbau.bashorov.task5;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 6/5/12
 * Time: 7:18 AM
 * RandomEvent ready for action if random integer is even
 */
public class RandomEvent extends Event{
    Random random = new Random();

    @Override
    public boolean ready() {
        return random.nextInt() % 2 == 0;
    }

}
