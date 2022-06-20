package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private boolean check(String line) {
        String[] log = line.split(" ");
        return log[log.length - 2].contains("404");
    }

    public List<String> filter(String file) {
        List<String> log = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (check(line)) {
                    log.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return log;
    }


    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        System.out.println(log);

    }
}