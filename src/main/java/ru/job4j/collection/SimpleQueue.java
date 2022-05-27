package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T rsl;
        try {
            while (true) {
                out.push(in.pop());
            }
        } catch (NoSuchElementException e) {
            rsl = out.pop();
        } finally {
            try {
                while (true) {
                    in.push(out.pop());
                }
            } catch (NoSuchElementException e) {
            }
            }
        return rsl;
    }

    public void push(T value) {
        in.push(value);
    }
}