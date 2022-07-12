package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (check(args)) {
            Path start = Paths.get(args[0]);
            search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
        }
    }

    public static boolean check(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Enter path and extension");
        }
        if (!Paths.get(args[0]).toFile().isDirectory()) {
            throw new IllegalArgumentException("Path is not a directory");
        }
        if (!Paths.get(args[0]).toFile().exists()) {
            throw new IllegalArgumentException("Path is not exists");
        }
        if (!(args[1]).startsWith(".")) {
            throw new IllegalArgumentException("Wrong extension");
        }
        return true;
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}