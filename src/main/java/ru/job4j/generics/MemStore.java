package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (mem.containsKey(id)) {
            return mem.replace(id, mem.get(id), model);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (findById(id) != null) {
            mem.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.containsKey(id) ? mem.get(id) : null;
    }
}
