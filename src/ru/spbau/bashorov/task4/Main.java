package ru.spbau.bashorov.task4;

/**
 * @author Zalim Bashorov
 */
public class Main {
    /**
     * Entry point.
     * @param args not used.
     */
    public static void main(String[] args) {
        Tester.run(10,    new RandomComparableIntegerFactory(), new IntegerModComparator(33), new ShakerSort(), new HeapSort());
        Tester.run(100,   new RandomComparableIntegerFactory(), new IntegerModComparator(33), new ShakerSort(), new HeapSort());
        Tester.run(1000,  new RandomComparableIntegerFactory(), new IntegerModComparator(33), new ShakerSort(), new HeapSort());
        Tester.run(10000, new RandomComparableIntegerFactory(), new IntegerModComparator(33), new ShakerSort(), new HeapSort());

        Tester.run(10,    new RandomComparableStringFactory(), new StringLengthComparator(), new ShakerSort(), new HeapSort());
        Tester.run(100,   new RandomComparableStringFactory(), new StringLengthComparator(), new ShakerSort(), new HeapSort());
        Tester.run(1000,  new RandomComparableStringFactory(), new StringLengthComparator(), new ShakerSort(), new HeapSort());
        Tester.run(10000, new RandomComparableStringFactory(), new StringLengthComparator(), new ShakerSort(), new HeapSort());
    }
}
