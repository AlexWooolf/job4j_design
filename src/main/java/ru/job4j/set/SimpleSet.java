package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        Iterator<T> iterator = set.iterator();
        boolean rsl = false;
        if (set.size() == 0) {
            rsl = true;
            set.add(value);
        } else {
            while (iterator.hasNext()) {
                if (iterator.next().equals(value)) {
                    rsl = false;
                    break;
                } else {
                    rsl = true;
                    set.add(value);
                }
            }
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> iterator = set.iterator();
        boolean rsl = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                rsl = true;
                break;
            } else {
                iterator.next();
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}