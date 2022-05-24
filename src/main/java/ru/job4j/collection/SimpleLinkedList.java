package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private int size;

    private int modCount;

    transient Node<E> first;

    transient Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        if (size == 0) {
            first = new Node<E>(value, null);
        } else {
            Node<E> newNode = new Node<E>(value, null);
            last = newNode;
            first.item = last.item;
            first.next = newNode;
        }
            modCount++;
            size++;
    }

    @Override
    public E get(int index) {
        Node<E> rsl = null;
        Objects.checkIndex(index, size);
        for (int i = 0; i <= index; i++) {
            rsl = first.next;
        }
         return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int cursor = 0;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return size > cursor;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(cursor++);
            }

        };
    }
}