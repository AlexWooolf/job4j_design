package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private Node<E>[] container;

    private int size;

    private int modCount;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(E value) {
        if (size == 0) {
            this.container = new Node[10];
            container[size] = new Node<E>(null, value, null);
        } else if (size == container.length) {
            newSize(container);
        } else {
            container[size] = new Node<E>(container[size - 1], value, null);
            container[size - 1] = new Node<E>(container[size - 1].prev, container[size - 1].item, container[size]);
        }
            modCount++;
            size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return container[index].item;
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
                return container[cursor++].item;
            }

        };
    }

    private void newSize(Node<E>[] first) {
            container = Arrays.copyOf(first, first.length * 2);
    }
}