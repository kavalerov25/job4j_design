package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean period = false;
            while (reader.ready()) {
                String[] pair = reader.readLine().split(" ");
                if (pair[0].equals("400") || pair[0].equals("500")) {
                    if (period) {
                        continue;
                    }
                    writer.printf("%s", pair[1]);
                    writer.printf("%s", ";");
                    period = true;
                } else if (period) {
                    writer.printf("%s%n", pair[1]);
                    period = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "target.csv");
    }
}