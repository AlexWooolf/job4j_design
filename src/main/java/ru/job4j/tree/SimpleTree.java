package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> tmpP = findBy(parent);
        if (tmpP.isPresent()) {
            Optional<Node<E>> tmpC = findBy(child);
            if (tmpC.isEmpty()) {
                tmpP.get().children.add(new Node<>(child));
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> condition = x -> Objects.equals(x.value, value);
        return findByPredicate(condition);

    }

    @Override
    public boolean isBinary() {
        Predicate<Node<E>> condition = x -> x.children.size() > 2;
            return findByPredicate(condition).isEmpty();
        }
}