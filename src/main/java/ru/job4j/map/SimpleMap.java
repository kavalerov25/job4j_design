package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public boolean put(K key, V value) {
        if (((float) count) / capacity >= LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return Math.abs(hash) % capacity;
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        count = 0;
        for (var entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new MapIt();
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class MapIt implements Iterator<K> {
        int elements = count;
        int index = -1;
        int expectedModCount = modCount;

        private int hash(int hashCode) {
            return hashCode ^ (hashCode >>> 16);
        }

        @Override
        public boolean hasNext() {
            return elements > 0;

        }

        @Override
        public K next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            K key = null;
            while (++index < table.length) {
                if (table[index] != null) {
                    key = table[index].key;
                    elements--;
                    break;
                }
            }
            return key;
        }
    }
}



