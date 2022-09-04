package ru.job4j.training;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Y1 {

    class Person {
        String name;

        byte day;
        byte month;
        short year;

        public Person(String name, byte day, byte month, short year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        var map = input();
    }



    public static LinkedHashMap<Person, String> input() {
        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort();
        LinkedHashMap<Person, String> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next() + scanner.next() + scanner.next();
            Person person = new Person(name, scanner.nextByte(), scanner.nextByte(), scanner.nextShort());
            map.put(person, null);
        }
        return map;
    }
}
