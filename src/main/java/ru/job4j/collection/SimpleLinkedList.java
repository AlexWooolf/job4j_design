package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private int size;

    private int modCount;

    private transient Node<E> first;

    private transient Node<E> last;

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
        Node<E> newNode = new Node<>(value, null);
        if (size == 0) {
            first = newNode;
            last = first;
        } else {
            Node<E> tmp = last;
            last = newNode;
            tmp.next = last;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
         return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int expectedModCount = modCount;

            int count = 0;

            Node<E> f = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rsl = f.item;
                f = f.next;
                count++;
                return rsl;
            }

        };
    }
}