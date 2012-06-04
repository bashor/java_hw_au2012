package ru.spbau.bashorov.task4;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zalim
 * Date: 3/20/12
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Sorter<T> {
    public <T extends Comparable<? super T>>  void sort(List<T> list);
    public <T extends Comparable<? super T>>  void sort(List<T> list, Comparator<T> c);
}
