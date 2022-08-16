package ru.job4j.tinkoff;

import java.util.*;

public class Solution6 {
    public static void main(String[] args) {
        var input = input();

    }

    public static Map<Integer, List<Segment>> input() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        TreeMap<Integer, List<Segment>> segments = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int finish = scanner.nextInt();
            segments.putIfAbsent(start, new ArrayList<>());
            segments.get(start).add(new Segment(start, finish));
        }
        return segments;
    }

        static int getMaxChain(TreeMap<Integer, List<Segment>> segments) {
        var left = segments.firstEntry();
        int maxChain = getChain(segments, left.getValue(), 0);
        return maxChain;
        }

    private static int getChain(TreeMap<Integer, List<Segment>> segments, List<Segment> left, int chainLength) {
        int maxChainLength = Integer.MIN_VALUE;
        for (Segment segment : left) {
            var segmentsConnectedWithLeft = segments.get(segment.finish);
            if (segmentsConnectedWithLeft == null) {
                return chainLength;
            } else {
                //TODO обработать ситуацию, когда начало и конец в одной точке
                int currentLength = getChain(segments, segmentsConnectedWithLeft, ++chainLength);
                if (currentLength > maxChainLength) {
                    maxChainLength = currentLength;
                }
            }
        }
        return maxChainLength;
    }

    static class Segment {
        private int start;
        private int finish;

        public Segment(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    }