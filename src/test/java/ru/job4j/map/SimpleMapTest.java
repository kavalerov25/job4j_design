package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void put() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "first"));
        String rsl = map.get(1);
        assertThat(rsl, is("first"));
    }

    @Test
    public void get() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertNull(map.get(1));
    }

    @Test
    public void remove() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        assertTrue(map.remove(1));
        assertNull(map.get(1));
    }

    @Test
    public void iterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        map.put(2, "second");
        map.put(3, "third");
        Iterator<Integer> it = map.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is(1));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(2));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(3));
        assertFalse(it.hasNext());
    }
}
