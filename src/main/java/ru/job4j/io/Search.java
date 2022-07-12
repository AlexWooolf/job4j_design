package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("c:\\projects\\job4j_design");
        if (args.length != 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        String str2 = ".md";
        if (check(path, str2)) {
            Path start = path;
            search(start, p -> p.toFile().getName().endsWith(str2)).forEach(System.out::println);
        }
    }

    public static boolean check(Path path, String str2) {
        if (!path.toFile().isDirectory()) {
            throw new IllegalArgumentException("Argument is not directory");
        }
        if (!path.toFile().exists()) {
            throw new IllegalArgumentException("Argument is not exists");
        }
        if (str2.isEmpty()) {
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