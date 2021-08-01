package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    @Test
    public void whenAddElement() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        assertThat(array.get(0), is(1));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenRemove() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("first");
        array.add("second");
        array.remove(0);
        assertThat(array.get(0), is("second"));
    }

    @Test
    public void whenSet() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("first");
        array.add("second");
        array.set(1, "three");
        assertEquals(array.get(1), "three");
    }
}