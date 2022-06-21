/*
package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean status = true;
        List<String> period = new ArrayList<>();
        List<String[]> l = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                l.add(line.split(" "));
            }
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i)[0].equals("400") || l.get(i)[0].equals("500")) {
                    status = false;
                    period.add(l.get(i)[1] + ";");
                } else if (!status) {
                    status = true;
                    period = period + s[1] + ";";
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(rsl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
