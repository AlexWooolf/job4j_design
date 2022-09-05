package ru.job4j.training;

import java.util.Scanner;

public class Yandex3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte first = scanner.nextByte();
        byte second = scanner.nextByte();
        short year = scanner.nextShort();
        System.out.println(check(first, second));
    }

    static byte check(byte first, byte second) {
        byte rsl = 0;
        if (first > 12 || second > 12 || second == first) {
            rsl = 1;
        }
        return rsl;
    }
}
