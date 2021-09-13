package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> answers = readPhrases();
        Random random = new Random();
        int index;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String ask = reader.readLine();
            boolean isContinue = true;
            while (!OUT.equals(ask)) {
                index = random.nextInt(answers.size());
                if (STOP.equals(ask)) {
                    isContinue = false;
                }
                if (CONTINUE.equals(ask)) {
                    log.add("user: " + ask);
                    isContinue = true;
                    ask = reader.readLine();
                    continue;
                }
                if (isContinue) {
                    String answer = answers.get(index);
                    log.add("user: " + ask);
                    log.add("ConsoleChat: " + answer);
                    System.out.println(answer);
                } else {
                    log.add("user: " + ask);
                }
                ask = reader.readLine();
            }
            log.add("user: " + ask);
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            while (reader.ready()) {
                answers.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251")))) {
            for (String w : log) {
                out.write(w + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/log.txt", "./data/botAnswers.txt");
        cc.run();
    }
}

