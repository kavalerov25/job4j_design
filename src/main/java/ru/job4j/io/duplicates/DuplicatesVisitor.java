package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Set<FileProperty> fileSet = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size = Files.size(file);
        String name = file.getFileName().toString();
        if (!fileSet.add(new FileProperty(size, name))) {
            System.out.println("Найден дубликат: " + file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}