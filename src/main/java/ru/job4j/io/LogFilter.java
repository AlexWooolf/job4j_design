package ru.job4j.io;

import java.io.*;
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

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String s : log) {
               out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("C:\\projects\\job4j_design\\data\\log.txt");
        save(log, "C:\\projects\\job4j_design\\data\\404.txt");
    }
}