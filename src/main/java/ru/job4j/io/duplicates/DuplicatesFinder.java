package ru.job4j.io.duplicates;

import ru.job4j.io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("c:\\projects\\job4j_design");
        DuplicatesVisitor finder = new DuplicatesVisitor();
        Files.walkFileTree(path, finder);
        Map<FileProperty, List<Path>> rsl = finder.getDuplicate();
        printRsl(rsl);
    }

    public static void printRsl(Map<FileProperty, List<Path>> rsl) {
        var keys = rsl.keySet();
        for (FileProperty f : keys) {
            System.out.println(f.toString());
            for (Path p: rsl.get(f)) {
                System.out.println(p);
            }
        }
    }
}