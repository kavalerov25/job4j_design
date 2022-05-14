package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    private <T> T findMinMax(List<T> values, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = values.get(0);
        for (T item : values) {
           rsl = predicate.test(comparator.compare(item, rsl)) ? item : rsl;
        }
        return rsl;
    }

    public <T> T max(List<T> values, Comparator<T> comparator) {
        return findMinMax(values, comparator, (comp -> comp > 0));
    }

    public <T> T min(List<T> values, Comparator<T> comparator) {
        return findMinMax(values, comparator, (comp -> comp < 0));
    }
}
