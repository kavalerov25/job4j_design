package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WorkTwo {
    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonTask = new JSONObject("{\"activity\":\"Выполнить задание\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Иванов");
        list.add("Сидоров");
        JSONArray jsonPerformers = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Work work = new Work(false, 3, new Task("Работу работать"), "Иванов", "Сидоров");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("done", work.isDone());
        jsonObject.put("time", work.getTime());
        jsonObject.put("contact", jsonTask);
        jsonObject.put("performers", jsonPerformers);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(work).toString());
    }
}