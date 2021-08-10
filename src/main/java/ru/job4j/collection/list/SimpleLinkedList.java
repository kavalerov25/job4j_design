package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;

    public SimpleLinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(E value) {
        var newNode = new Node<>(value, null);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = first;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIt();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private class ListIt implements Iterator<E> {
        int point = 0;
        int expectedModCount = modCount;
        Node<E> lastReturned;

        @Override
        public boolean hasNext() {
            return point < size;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (point >= size) {
                throw new NoSuchElementException();
            }
            if (lastReturned == null) {
                lastReturned = first;
            } else {
                lastReturned = lastReturned.next;
            }
            point++;
            return lastReturned.item;
        }
    }
}