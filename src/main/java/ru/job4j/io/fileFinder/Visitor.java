package ru.job4j.io.fileFinder;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Visitor extends SimpleFileVisitor<Path> {

    private Predicate<Path> condition;

    private List<Path> list = new ArrayList<>();

    public Visitor(Predicate<Path> condition) {
        this.condition = condition;
    }

    public List<Path> getFoundFile() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            list.add(file);
        }

        return FileVisitResult.CONTINUE;
    }
}