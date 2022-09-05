package ru.job4j.training;

import java.util.Scanner;

public class Yandex2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte length = scanner.nextByte();
        byte start = scanner.nextByte();
        byte finish = scanner.nextByte();
        System.out.println(getBestWay(length, start, finish));
    }

    static byte getBestWay(byte length, byte start, byte finish) {
        byte way1 = 0;
        byte way2 = 0;
        byte rsl = 0;
        if (start < finish) {
            way1 = (byte) (finish - start);
            way2 = (byte) (length - finish + start);
        } else {
            way1 = (byte) (start - finish);
            way2 = (byte) (length - start + finish);
        }
        if (way1 < way2) {
            rsl = (byte) (way1 - 1);
        } else {
            rsl = (byte) (way2 - 1);
        }
        return rsl;
    }
}
