package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int i;
            while ((i = in.read()) != -1) {
                text.append((char) i);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            int[] n = new int[lines.length];
            for (int j = 0; j < n.length; j++) {
                n[j] = Integer.parseInt(lines[j]);
            }
            for (int num : n) {
                if (num % 2 == 0) {
                    System.out.println(num);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

