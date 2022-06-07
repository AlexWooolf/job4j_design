package ru.job4j.map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.security.Key;
import java.util.Iterator;

public class SimpleMapTest {

    @Test
    public void testPut1() {
        SimpleMap map = new SimpleMap();
        assertTrue(map.put("key1", "value1"));
    }

    @Test
    public void testPut2() {
        SimpleMap map = new SimpleMap();
        int key = 1;
       map.put(key, "value1");
       assertFalse(map.put(key, "value2"));
    }

    @Test
    public void testGet1() {
        SimpleMap map = new SimpleMap();
        int key = 1;
        int value = 2;
        map.put(key, value);
        assertThat(map.get(key), is(value));
    }

    @Test
    public void testGet2() {
        SimpleMap map = new SimpleMap();
        int key = 1;
        assertNull(map.get(key));
    }

    @Test
    public void testRemove1() {
        SimpleMap map = new SimpleMap();
        int key = 1;
        int value = 2;
        map.put(key, value);
        assertTrue(map.remove(key));
    }

    @Test
    public void testRemove2() {
        SimpleMap map = new SimpleMap();
        int key = 1;
        int value = 2;
        map.put(key, value);
        assertFalse(map.remove(2));
    }

    @Test
    public void testIterator1() {
        SimpleMap map = new SimpleMap();
        int key = 1;
        int value = 2;
        map.put(key, value);
        Iterator<Key> it = map.iterator();
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void testIterator2() {
        SimpleMap map = new SimpleMap();
        Iterator<Key> it = map.iterator();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void testIterator3() {
        SimpleMap map = new SimpleMap();
        int key = 1;
        int value = 2;
        map.put(key, value);
        Iterator it = map.iterator();
        assertThat(it.next(), is(key));
    }

    @Test
    public void testIterator4() {
        SimpleMap map = new SimpleMap();
        int key = 1;
        int value = 2;
        int key2 = 3;
        int value2 = 4;
        map.put(key, value);
        map.put(key2, value2);
        Iterator it = map.iterator();
        it.next();
        assertThat(it.next(), is(key2));
    }
}