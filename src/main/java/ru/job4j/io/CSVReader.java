package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        check(argsName);
        String[] lines;
        ArrayList<StringJoiner> rsl = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new FileReader(argsName.get("path"), Charset.forName("WINDOWS-1251")))) {
            List<Integer> index = filter(argsName, scanner.nextLine());
            while (scanner.hasNext()) {
                StringJoiner line = new StringJoiner(argsName.get("delimiter"));
                lines = scanner.nextLine().split(argsName.get("delimiter"));
                for (Integer i : index) {
                line.add(lines[i]);
                }
                rsl.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        print(argsName, rsl);
    }


    private static List<Integer> filter(ArgsName argsName, String line) {
        List<Integer> index = new ArrayList<>();
        String[] filterStrings = argsName.get("filter").split(",");
        String[] words = line.split(argsName.get("delimiter"));
        for (int i = 0; i < filterStrings.length; i++) {
            for (String word : words) {
                if (filterStrings[i].equals(word)) {
                    index.add(i);
                    }
                }
            }
        return index;
        }

        private static void print(ArgsName argsName, ArrayList<StringJoiner> rsl) throws FileNotFoundException {
            if ("stdout".equals(argsName.get("out"))) {
                System.out.println(argsName.get("filter").replace(",", argsName.get("delimiter")));
                rsl.forEach(System.out::println);
            } else {
                try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(argsName.get("out"))))) {
                    out.println(argsName.get("filter").replace(",", argsName.get("delimiter")));
                    rsl.forEach(out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private static void check(ArgsName argsName) {
            if (argsName.length() != 4) {
                throw new IllegalArgumentException("Need 4 args");
            }
            if (!Paths.get(argsName.get("path")).toFile().exists()) {
                throw new IllegalArgumentException("File does not exists");
            }
            if (Paths.get(argsName.get("path")).toFile().isDirectory()) {
                throw new IllegalArgumentException("Path is a directory");
            }
            if (!argsName.get("path").endsWith(".csv")) {
                throw new IllegalArgumentException("Wrong extension");
            }
        }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}

