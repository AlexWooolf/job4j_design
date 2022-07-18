package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArgsName check(String[] args) {
        ArgsName params = ArgsName.of(args);
        if (args.length != 3) {
            throw new IllegalArgumentException("Need 3 parameters");
        }
        if (!Path.of(params.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("Path is not a directory");
        }
        if (!(params.get("e").startsWith("."))) {
            throw new IllegalArgumentException("wrong extension");
        }
        if (!(params.get("o").endsWith(".zip"))) {
            throw new IllegalArgumentException("wrong target");
        }
        return params;
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        var params = zip.check(args);
        var list = Search.search(Paths.get(params.get("d")), p -> p.toFile().getName().endsWith(params.get("e")));
        zip.packFiles(list, new File(params.get("o")));
    }
}




