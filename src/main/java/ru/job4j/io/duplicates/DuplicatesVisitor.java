package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Predicate;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, List<Path>> duplicate = new HashMap<>();

    public Map<FileProperty, List<Path>> getDuplicate() {
        return duplicate;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file);
        ArrayList<Path> list = new ArrayList<>();
        list.add(file);
        if (duplicate.putIfAbsent(fileProperty, list) != null) {
            list.addAll(duplicate.get(fileProperty));
            duplicate.put(fileProperty, list);
        }
        return FileVisitResult.CONTINUE;
    }
}