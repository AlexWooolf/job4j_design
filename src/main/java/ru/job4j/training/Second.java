package ru.job4j.training;

import java.util.*;

public class Second {

    static class Team {
        private final List<String> names;

        Team(String names) {
            String[] array = names.split(" ");
            Arrays.sort(array);
            this.names = Arrays.asList(array);
        }

        @Override
        public boolean equals(Object o) {
            return o == this || o instanceof Team && ((Team) o).names.equals(this.names);
        }

        @Override
        public int hashCode() {
            return names.hashCode();
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // число строк
        Map<Team, Integer> wins = new HashMap<>(); // число побед

        for (int i = 0; i < n; i++) { // ввод данных
            String names = scanner.nextLine();
            Team team = new Team(names);
            Integer previousCount = wins.getOrDefault(team, 0);
            wins.put(team, previousCount + 1);
        }
        int maxWins = 0;
        for (Integer value : wins.values()) {
            if (value > maxWins) {
                maxWins = value;
            }
        }
        System.out.println(maxWins);
    }

    public static void main(String[] args) {
        new Second().run();
    }
}