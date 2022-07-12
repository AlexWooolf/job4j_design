package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("No element with this key" + key);
        }
        return values.get(key);
    }

    private void check(String s) {
        if (!s.contains("=") || !s.startsWith("-")) {
            throw new IllegalArgumentException("Illegal syntax" + s);
        }
        String[] split = s.split("=", 2);
        if (split[0].length() < 2 || split[1].length() == 0) {
            throw new IllegalArgumentException("Empty key or value" + s);
        }
    }


    private void parse(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("No args found");
        }
        for (String a : args) {
            check(a);
            String[] split = a.split("=", 2);
            values.put(split[0].substring(1), split[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xms"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}