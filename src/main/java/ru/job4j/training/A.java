package ru.job4j.training;

import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine()); // ввод количества строк
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine().split(" "));
        }
        for (String[] s : list) {
            System.out.println(s[0] + s[1] + s[2]);
        }
    }
}
