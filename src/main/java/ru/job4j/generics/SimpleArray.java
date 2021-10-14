package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @param <T> - дженерик
 *            В классе реализован ArrayList
 * @author Kirill Kavalerov
 * @version 1.0
 */

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int size;

    public SimpleArray(int count) {

        this.array = (T[]) new Object[count];
    }

    /**
     * @param model - добавляет указанный элемент (model) в первую свободную ячейку
     */

    public void add(T model) {
        array[size] = model;
        size++;
    }


    /**
     * Метод меняет исходящий элемент на новый
     * @param index - исходный элемент
     * @param model - новый элемент
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    /**
     * remove(int index) - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом необходимо сдвинуть
     * на единицу влево (в середине массива не должно быть пустых ячеек)
     * @param index - принимает индекс по которому нужно удалить элемент
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;

    }

    /**
     * Метод возвращает индекс элемента
     * @param index - индекс
     * @return - возвращает индекс
     */
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }

    /**
     * Итератор последовательно проходит по элементам, пока они есть в массиве
     * @return - вернуть следующий элемент.
     */

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