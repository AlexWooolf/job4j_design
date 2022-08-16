package ru.job4j.tinkoff;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = scanner.nextInt();
        }
        System.out.println(getBestSum(days));
    }

        static int getBestSum(final int[] days) {
            int oldSum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int k = 0; k < days.length; k++) {
                if (k % 2 == 0) {
                    if (days[k] > max) {
                        max = days[k];
                    }
                    oldSum = oldSum + days[k];
                } else {
                    if (days[k] < min) {
                        min = days[k];
                    }
                    oldSum = oldSum - days[k];
                }
            }
            int newSum = oldSum + min * 2 - max * 2;
            if (newSum < oldSum) {
                newSum = oldSum;
            }
            return newSum;
        }
    }