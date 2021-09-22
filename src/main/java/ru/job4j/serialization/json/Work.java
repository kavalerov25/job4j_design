package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Work {
    private final boolean done;
    private final int time;

    public boolean isDone() {
        return done;
    }

    public int getTime() {
        return time;
    }

    public Task getTask() {
        return task;
    }

    public String[] getPerformers() {
        return performers;
    }

    private final Task task;
    private final String[] performers;

    public Work(boolean done, int time, Task task, String... performers) {
        this.done = done;
        this.time = time;
        this.task = task;
        this.performers = performers;
    }

    @Override
    public String toString() {
        return "Work{"
               + " done=" + done
               + ", time=" + time
               + ", task=" + task
               + ", performers=" + Arrays.toString(performers)
               + '}';
    }

    public static void main(String[] args) {
        final Work work = new Work(false, 3, new Task("Выполнить задачи по установке оборудования"), "Петров", "Сидоров");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(work));

        /* Модифицируем json-строку */
        final String workJson =
                "{"
                + "\"done\":false,"
                + "\"time\":4,"
                + "\"task\":"
                + "{"
                + "\"activity\":\"Выполнить задачи по установке оборудования\""
                + "},"
                + "\"performers\":"
                + "[\"Васечкин\",\"Козлов\"]"
                + "}";
        final Work workMod = gson.fromJson(workJson, Work.class);
        System.out.println(workMod);
    }
}