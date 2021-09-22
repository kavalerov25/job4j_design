package ru.job4j.serialization.json;

public class Task {
    private final String activity;

    public Task(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return "Task{"
               + "activity='" + activity + '\''
               + '}';
    }
}



