package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder or extension of file is null. Usage java -jar dir.jar ROOT_FOLDER EXTENSION_FILE.");
        }
        Path start = Paths.get(args[0]);
        System.out.println(search(start, p -> p
                .toFile()
                .getName()
                .endsWith(args[1])));
    }


    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}