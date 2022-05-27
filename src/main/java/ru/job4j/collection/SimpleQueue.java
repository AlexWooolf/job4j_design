package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.isEmpty() && in.isEmpty()) {
    throw  new NoSuchElementException();
        }
        T rsl;
        if (!out.isEmpty()) {
            rsl = out.pop();
        } else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            rsl = out.pop();
        }
        return rsl;
    }

    public void push(T value) {
        in.push(value);
    }

    public static void main(String[] args) {
        SimpleQueue n = new SimpleQueue();
        n.push(1);
        n.poll();
    }
}
