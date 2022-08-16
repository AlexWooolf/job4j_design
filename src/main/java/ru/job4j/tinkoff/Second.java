package ru.job4j.tinkoff;

import java.util.*;

public class Second {

    class Team {
        private List<String> names;

        public Team(List<String> names) {
            this.names = names;
        }

        private boolean check(Team t) {
            return this.names.contains(t.names.get(0)) && this.names.contains(t.names.get(1)) && this.names.contains(t.names.get(2));
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); // число строк
        ArrayList<Integer> wins = new ArrayList<>(n); // число побед
        ArrayList<Team> teams = new ArrayList<>(n); // команды
        for (int i = 0; i < n; i++) { // ввод данных
            String[] names = scanner.nextLine().split(" ");
            teams.add(i, new Team(Arrays.asList(names)));
            wins.add(i, 1);
        }
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                if (teams.get(i).check(teams.get(j))) { //при проверке на имена внутри команды счётчик побед + 1,
                    wins.set(i, wins.get(i) + 1);
                }
            }
        }
        for (int i : wins) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Second().run();
    }
}
