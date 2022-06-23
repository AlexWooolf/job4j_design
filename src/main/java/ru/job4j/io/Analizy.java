package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean status = true;
        int count = 0;
        List<String> period = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (status && (line.contains("400") || line.contains("500"))) {
                    status = false;
                    period.add(count, line.split(" ")[1] + ";");
                } else if (!status && (line.contains("200") || line.contains("300"))) {
                    status = true;
                    String tmp = period.get(count);
                    period.set(count, tmp + line.split(" ")[1] + ";");
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy first = new Analizy();
        first.unavailable("./data/server.log", "./data/period.txt");
    }
}