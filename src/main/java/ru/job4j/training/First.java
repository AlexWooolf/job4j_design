package ru.job4j.training;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] office1 = new int[4];
        int[] office2 = new int[4];
        int x = 0;
        int y = 0;
        for (int i = 0; i < 4; i++) {
            office1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            office2[i] = scanner.nextInt();
        }
        if (office1[0] < office2[0]) {
            x = office2[2] - office1[0];
        } else {
            x = office1[2] - office2[0];
        }
        if (office1[1] < office2[1]) {
            y = office2[3] - office1[1];
        } else {
            y = office1[3] - office2[1];
        }
        if (x > y) {
            System.out.println(x * x);
        } else {
            System.out.println(y * y);
        }
    }
}
