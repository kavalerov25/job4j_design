package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class MemStoreTest {
    @Test
    public void delete() {
        User u = new User("user");
        User u1 = new User("user1");
        MemStore<User> mem = new MemStore<>();
        mem.add(u);
        mem.delete("user");
        assertNull(mem.findById("user"));
    }
}