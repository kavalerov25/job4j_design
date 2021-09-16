package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    private static ArgsName arguments = new ArgsName();

    private static void validate(ArgsName arguments) {
        String[] parameters = {"Path", "Delimiter", "Out", "Filter"};
        for (String parameter : parameters) {
            if (arguments.get(parameter.toLowerCase()) == null) {
                throw new IllegalArgumentException(String.format(
                        "%s parameter not found.", parameter));
            }
        }
        CSVReader.arguments = arguments;
        if (!Paths.get(arguments.get("path")).toFile().isFile()) {
            throw new IllegalArgumentException(String.format("File '%s' is missing.",
                    arguments.get("path")));
        }
        if (!arguments.get("delimiter").equals(";") && !arguments.get("delimiter").equals(",")) {
            throw new IllegalArgumentException("Wrong delimiter. Usage ',' or ';'.");
        }
    }

    private static boolean check(String value, String[] filters) {
        boolean rsl = false;
        for (String filter : filters) {
            if (filter.equals(value)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static String parse(String line, String[] columns, String[] filters) {
        String delimiter = arguments.get("delimiter");
        StringJoiner rsl = new StringJoiner(delimiter);
        try (Scanner sc = new Scanner(new ByteArrayInputStream(line
                .getBytes())).useDelimiter(delimiter)) {
            int index = 0;
            while (sc.hasNext()) {
                String value = sc.next();
                if (check(columns[index++], filters)) {
                    rsl.add(value);
                }
            }
        }
        return rsl.toString();
    }

    private static void processData() throws FileNotFoundException {
        String[] filters = arguments.get("filter").split(",");
        try (Scanner scanner = new Scanner(Paths.get(arguments.get("path")).toFile());
             PrintWriter writer = new PrintWriter(arguments.get("out").equals("stdout")
                     ? System.out
                     : new FileOutputStream(arguments.get("out")))) {
            if (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] columns = line.split(arguments.get("delimiter"));
                String headline = parse(line, columns, filters);
                if (headline.equals("")) {
                    throw new IllegalArgumentException("Wrong filter values.");
                }
                writer.println(headline);
                while (scanner.hasNext()) {
                    writer.println(parse(scanner.nextLine(), columns, filters));
                }
            }
        }
    }

    public static void handle(ArgsName arguments) throws IOException {
        validate(arguments);
        processData();
    }

    public static void main(String[] args) throws IOException {
        CSVReader.handle(ArgsName.of(args));
    }
}