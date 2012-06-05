package ru.spbau.bashorov.task3;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 6/5/12
 * Time: 8:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Expression {
    public int evaluate(HashMap<String, Expression> context);
}
