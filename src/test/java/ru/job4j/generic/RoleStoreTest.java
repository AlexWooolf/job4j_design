package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRoleNameIsFirst() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "first"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("first"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "first"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleNameIsFirst() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "first"));
        store.add(new Role("1", "second"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("first"));
    }

    @Test
    public void whenReplaceThenRoleNameIsSecond() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "first"));
        store.replace("1", new Role("1", "second"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("second"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "first"));
        store.replace("2", new Role("2", "second"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("first"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "first"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRoleNameIsFirst() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "first"));
        store.delete("2");
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("first"));
    }
}