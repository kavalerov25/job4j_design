package ru.job4j.kiss;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaxMinTest {

    @Test
    public void max() {
        MaxMin maxMin = new MaxMin();
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(maxMin.<Integer>max(values, Integer::compareTo), is(5));
    }

    @Test
    public void min() {
        MaxMin maxMin = new MaxMin();
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(maxMin.<Integer>min(values, Integer::compareTo), is(1));
    }
}