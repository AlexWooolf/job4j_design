package ru.job4j.training;

import java.util.Scanner;

public class Yandex4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coordinates = new int[n];
        for (int i = 0; i < n - 1; i++) {
            coordinates[i] = scanner.nextInt();
        }
        System.out.println(getBestPoint(coordinates));
    }

    static int getBestPoint(int[] coordinates) {
        int rsl = 0;
        if (coordinates.length % 2 == 0) {
            rsl = coordinates[coordinates.length / 2];
        } else {
            rsl = coordinates[coordinates.length / 2 + 1];
        }
        return rsl;
    }
}
