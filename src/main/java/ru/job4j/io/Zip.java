package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile().getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArgsName validateArgs(String[] args) {
        ArgsName arguments = ArgsName.of(args);
        Path directory = Path.of(arguments.get("d"));
        Path output = Path.of(arguments.get("o"));
        String exclude = arguments.get("e");

        if (args.length != 3 || directory == null || output == null || exclude == null) {
            throw new IllegalArgumentException("The required arguments are missing");
        }
        if (!Files.exists(Paths.get(arguments.get("d")))) {
            throw new IllegalArgumentException("The directory does not exist!");
        }
        return arguments;
    }

    public static void main(String[] args) {
        ArgsName arguments = validateArgs(args);
        Path directory = Path.of(arguments.get("d"));
        Path output = Path.of(arguments.get("o"));
        String exclude = arguments.get("e");
        try {
            List<Path> search = Search.search(directory, s -> !s.toFile().getName().endsWith(exclude));
            packFiles(search, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}