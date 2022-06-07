package ru.job4j.map;

import java.security.Key;
import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl;
        if (count / capacity >= LOAD_FACTOR) {
        expand();
        }
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
        rsl = false;
        } else {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode ^ (hashCode >>> capacity)) & (capacity - 1);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        table = Arrays.copyOf(table, capacity * 2);

    }

    @Override
    public V get(K key) {
        V rsl = null;
        int index = indexFor(hash(key.hashCode()));
        Objects.checkIndex(index, capacity);
        if (table[index] != null) {
            rsl = table[index].value;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFor(hash(key.hashCode()));
        Objects.checkIndex(index, capacity - 1);
        if (table[index] != null) {
            table[index] = null;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {

            private int cursor = 0;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = cursor; i < capacity - 1; i++) {
                    if (table[i] != null) {
                    rsl = true;
                    break;
                    }
                }
                return rsl;
            }

            @Override
            public K next() {
                K rsl = null;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int i = cursor; i < capacity - 1; i++) {
                    if (table[i] != null) {
                        rsl = table[i].key;
                        cursor = i + 1;
                        break;
                    }
                }
                return rsl;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        SimpleMap map = new SimpleMap();
        int key = 1;
        int value = 2;
        map.put(key, value);
        map.put(3, 4);
        System.out.println(map.get(key));
        Iterator<Key> it = map.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());

    }
}