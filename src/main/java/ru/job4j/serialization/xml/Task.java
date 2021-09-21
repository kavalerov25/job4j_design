package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task")

public class Task {
    @XmlAttribute
    String activity;

    public Task() {
    }

    public Task(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Task{"
               + "activity='" + activity + '\''
               + '}';
    }
}