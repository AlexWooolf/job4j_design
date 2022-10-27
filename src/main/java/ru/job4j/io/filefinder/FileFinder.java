package ru.job4j.io.filefinder;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {

    private void validate(ArgsName args) {
        if (!Path.of(args.get("-d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("Search folder is incorrect");
        }
        if (!args.get("-t").contains("mask")) {
            if (!args.get("-t").contains("name")) {
                if (!args.get("-t").contains("regex")) {
                    throw new IllegalArgumentException("Wrong search type. Enter 'mask', 'name', or 'regex'!");
                }
            }
        }
        if (!args.get("o").endsWith(".txt")) {
            throw new IllegalArgumentException("File name for writing data is not correct. Enter a filename with .txt extension!");
        }
    }

    public List<Path> selectSearchType(ArgsName args) throws IOException {
        List<Path> rsl;
        if (args.get("-t").equals("mask")) {
            String regex = args.get("-n").replace("*", ".").replace("?", ".").replace(".", "[.]");
            Pattern pattern = Pattern.compile(regex);
            rsl = search(Path.of(args.get("-d")), p -> pattern.matcher(p.toFile().getName()).find());
        } else if (args.get("-t").equals("name")) {
            rsl = search(Path.of(args.get("-d")), p -> p.toFile().getName().equals(args.get("-n")));
        } else if (args.get("-t").equals("regex")) {
            rsl = search(Path.of(args.get("-d")), p -> p.toFile().getName().matches(args.get("-n")));
        } else {
            throw new IllegalArgumentException("Wrong search type");
        }
        return rsl;
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        Visitor visitor = new Visitor(condition);
        Files.walkFileTree(root, visitor);
        return visitor.getFoundFile();
    }

    private void output(List<Path> list, Path path) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path.toFile())
                ))) {
            for (Path p : list) {
                out.println(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileFinder fileFinder = new FileFinder();
        ArgsName argsName = ArgsName.of(args);
        fileFinder.validate(argsName);
        List<Path> rsl = fileFinder.selectSearchType(argsName);
        fileFinder.output(rsl, Path.of(argsName.get("-o")));
    }
}

