package ru.job4j.training;

import java.util.ArrayList;
import java.util.List;

public class B {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("one");
                list.add("two");
        list.add(1 + 7);
        System.out.println(list.get(2));
        }
    }

