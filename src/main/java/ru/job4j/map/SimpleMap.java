package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

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
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
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