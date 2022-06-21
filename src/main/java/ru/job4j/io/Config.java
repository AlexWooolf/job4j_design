package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /*public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines()
                    .filter(l -> l.length() > 0 && !l.contains("#"))
                    .map(l -> l.split("="))
                    .filter(l -> l.length == 2 && l[0] != null && l[1] != null)
                    .forEach(l -> values.put(l[0], l[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if ((!line.contains("=") && line.length() > 1) || line.startsWith("=") || (line.indexOf("=") == line.length() && line.endsWith("="))) {
                    throw new IllegalArgumentException("Запись не соответствует шаблону");
                } else if (line.contains("=") && !line.startsWith("#")) {
                    var rsl = line.split("=", 2);
                    values.put(rsl[0], rsl[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        config.load();
        System.out.println(config.values);
    }
}