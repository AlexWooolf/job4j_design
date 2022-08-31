package ru.job4j.training;

import java.util.Scanner;

public class JandexT1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            byte code = scanner.nextByte();
            byte interactor = scanner.nextByte();
            byte checker = scanner.nextByte();
        System.out.println(getResult(code, interactor, checker));
    }

    static byte getResult(byte code, byte interactor, byte checker) {
        byte rsl = interactor;
        if (interactor == 0 && code != 0) {
            rsl = 3;
        } else if (interactor == 1) {
            rsl = checker;
        } else if (interactor == 4 && code != 0) {
            rsl = 3;
        } else if (interactor == 4 && code == 0) {
            rsl = 4;
        } else if (interactor == 6) {
            rsl = 0;
        } else if (interactor == 7) {
            rsl = 1;
        }
        return rsl;
    }
}
