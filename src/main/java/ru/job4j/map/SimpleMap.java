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
        if ((float) count / (float) capacity >= LOAD_FACTOR) {
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
        return (hashCode == 0) ? 0 : (hashCode ^ (hashCode >>> 16)) & (capacity - 1);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        table = Arrays.copyOf(table, capacity * 2);
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        capacity = capacity * 2;
        for (MapEntry<K, V> kvMapEntry : table) {
            if (kvMapEntry != null) {
                int newIndex = indexFor(hash(kvMapEntry.key.hashCode()));
                newTable[newIndex] = kvMapEntry;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V rsl = null;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && key == table[index].key) {
            rsl = table[index].value;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && key == table[index].key) {
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
                    cursor = i;
                    break;
                    }
                }
                return rsl;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++].key;
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
}