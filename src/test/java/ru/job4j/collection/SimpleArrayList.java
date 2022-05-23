package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    private int cursor = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            container = newSize(container);
        }
        container[size] = value;
        modCount++;
        size++;
    }

    @Override
    public T set(int index, T newValue) {
        T temp = container[index];
        container[index] = newValue;
        modCount++;
        return temp;
    }

    @Override
    public T remove(int index) {
        T tmp = container[index];
        System.arraycopy(container, index + 1, container, index,container.length - index - 1);
        container[container.length - 1] = null;
        modCount++;
        size--;
        return tmp;
    }

    @Override
    public T get(int index) {
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {


        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return container.length > cursor && container[cursor] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }

        };
    }

    private T[] newSize(T[] first) {
     return Arrays.copyOf(first, first.length * 2);
    }
}