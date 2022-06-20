package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFilter {
    public List<String> filter(String file) {
        List<String[]> log = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                log.add(line.split(" "));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "";
        List<String> rsl = new ArrayList<>();
        log = log.stream()
                .filter(x -> x[x.length - 2].contains("404"))
                .collect(Collectors.toList());
        for (String[] string : log) {
            for (String s : string) {
                str = str + " " + s;
            }
           rsl.add(str);
            str = "";
        }
        return rsl;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        System.out.println(log);

    }
}