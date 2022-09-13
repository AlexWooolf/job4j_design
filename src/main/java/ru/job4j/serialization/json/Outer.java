package ru.job4j.serialization.json;

import java.util.ArrayList;
import java.util.List;

public class Outer {
    private  int x = 5;
    protected class Inner {
        public static  int x = 10;
        public void go() {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        List<? extends  Number> nums = new ArrayList<Integer>();
        List<? extends  Integer> numss = new ArrayList<Integer>();
        List<Number> numfss = new ArrayList<Number>();
        List<?> numffss = new ArrayList<Number>();

    }
}
