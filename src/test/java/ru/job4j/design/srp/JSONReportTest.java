package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JSONReportTest {

    @Test
    public void whenJSONTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Gson gson = new GsonBuilder().create();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new JSONReport(store);
        StringBuilder expect = new StringBuilder()
                .append("[{")
                .append("\"name\":").append(gson.toJson(worker.getName())).append(",")
                .append("\"hired\":").append(gson.toJson(worker.getHired())).append(",")
                .append("\"fired\":").append(gson.toJson(worker.getFired())).append(",")
                .append("\"salary\":").append(gson.toJson(worker.getSalary()))
                .append("}]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}