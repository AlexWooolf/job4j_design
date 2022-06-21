package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean status = true;
        int count = 0;
        List<String> period = new ArrayList<>();
        List<String[]> l = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                l.add(line.split(" "));
            }
            for (int i = 0; i < l.size(); i++) {
                if ((l.get(i)[0].equals("400") || l.get(i)[0].equals("500")) && status) {
                    status = false;
                    period.add(count, l.get(i)[1] + ";");
                } else if (!status) {
                    status = true;
                    period.add(count + 1, l.get(i)[1] + ";");
                    count++;
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(period);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy first = new Analizy();
        first.unavailable("./data/server.log", "./data/period.txt");
    }
}