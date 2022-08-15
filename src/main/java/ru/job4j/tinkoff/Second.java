package ru.job4j.tinkoff;

import java.util.*;

public class Second {

    class Team {
        private List<String> names;

        public Team(List<String> names) {
            this.names = names;
        }

        private boolean check(Team t) {
            boolean rsl = this.names.contains(t.names.get(0)) && this.names.contains(t.names.get(1)) && this.names.contains(t.names.get(2));
            return rsl;
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); // число строк
        ArrayList<Integer> wins = new ArrayList<>(n);
        ArrayList<Team> teams = new ArrayList<>(n);
        for (int i = 0; i < n; i++) { // ввод данных
            String[] names = scanner.nextLine().split(" ");
            teams.add(i, new Team(Arrays.asList(names)));
            wins.add(i, 1);
        }
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size() - 1; j++) {
                if (teams.get(i).check(teams.get(j))) { //при проверке на имена внутри команды счётчик побед + 1
                    wins.add(i, wins.get(i) + 1);
                    teams.remove(j);
                    wins.remove(j);
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
