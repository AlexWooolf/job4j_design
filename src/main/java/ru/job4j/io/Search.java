package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        String str1 = "c:\\projects\\job4j_design";
        String str2 = ".md";
        if (check(str1, str2)) {
            Path start = Paths.get(str1);
            search(start, p -> p.toFile().getName().endsWith(str2)).forEach(System.out::println);
        }
    }

    public static boolean check(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Argument is null");
        }
        if (!str2.startsWith(".")) {
            throw new IllegalArgumentException("Not an expansion");
        }
        return true;
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}