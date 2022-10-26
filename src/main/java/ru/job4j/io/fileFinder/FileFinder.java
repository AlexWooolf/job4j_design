/*
package ru.job4j.io.fileFinder;

import ru.job4j.io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class FileFinder {

    private boolean validate(ArgsName args) {

        return true;
    }

    public List<Path> selectSearchType(ArgsName args) throws IOException {
        if (args.get("-t").equals("mask")) {

        } else if (args.get("-t").equals("name")) {
            return search(Path.of(args.get("-d")), p -> p.toFile().getName().equals(args.get("-n")));
        } else if (args.get("-t").equals("regex")) {

        } else {
            throw new IllegalArgumentException("Wrong search type");
        }
    }

    private void searchByMask() {

    }

    private void searchByName() {

    }

    private void searchByRegex() {

    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        Visitor visitor = new Visitor(condition);
        Files.walkFileTree(root, visitor);
        return visitor.getFoundFile();
    }

    private void output(List<Path> list, Path path) {

    }

    public static void main(String[] args) {
        FileFinder fileFinder = new FileFinder();
        ArgsName argsName = ArgsName.of(args);
        fileFinder.validate(argsName);
        List<Path> rsl = fileFinder.selectSearchType(argsName);
        fileFinder.output(rsl, Path.of(argsName.get("-o")));
    }

}
*/
