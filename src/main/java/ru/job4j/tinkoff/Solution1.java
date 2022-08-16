package ru.job4j.tinkoff;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        new Solution1().new Solution().solution1();
    }

    class Solution {
        public void solution1() {
            Scanner scanner = new Scanner(System.in);
            int[] office1 = new int[4];
            int[] office2 = new int[4];

            for (int i = 0; i < 4; i++) {
                office1[i] = scanner.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                office2[i] = scanner.nextInt();
            }

            int res = getBiggestSquare(office1, office2);
            System.out.println(res);
        }

        int getBiggestSquare(final int[] office1, final int[] office2) {
            int x = 0;
            int y = 0;
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

            return x > y ? x * x : y * y;
        }


    }
}