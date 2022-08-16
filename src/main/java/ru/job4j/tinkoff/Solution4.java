package ru.job4j.tinkoff;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();
        Map<String, Integer> surnames = new HashMap<>();
        List<String> requests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            surnames.put(scanner.nextLine(), i);
        }
        for (int i = 0; i < q; i++) {
            requests.add(scanner.nextLine());
        }
        for (String request : requests) {
            String[] splitRequest = request.split(" ");
            System.out.println(getIndex(surnames, Integer.parseInt(splitRequest[0]), splitRequest[1]));
        }
    }

        static int getIndex(Map<String, Integer> surnames, int index, String prefix) {

            Set<String> list = surnames.keySet();
            List<String> sortedSurnames = new ArrayList<>(list);
            Collections.sort(sortedSurnames);
            int foundCounter = 0;
            for (String sortedSurname : sortedSurnames) {
                if (sortedSurname.startsWith(prefix)) {
                    foundCounter++;
                    if (foundCounter == index) {
                        return surnames.get(sortedSurname);
                    }
                }
            }
            return -1;
        }
    }