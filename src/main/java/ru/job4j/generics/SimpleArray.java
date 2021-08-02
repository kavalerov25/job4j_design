package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int size;

    public SimpleArray(int count) {
        this.array = (T[]) new Object[count];
    }

    //add(T model) - добавляет указанный элемент (model) в первую свободную ячейку
    public void add(T model) {
        array[size] = model;
        size++;
    }

    //set(int index, T model) - заменяет указанным элементом (model) элемент, находящийся по индексу index
    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    //remove(int index) - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом необходимо сдвинуть
    // на единицу влево (в середине массива не должно быть пустых ячеек)
    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;

    }

    //get(int index) - возвращает элемент, расположенный по указанному индексу;
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[point++];
            }
        };
    }
}