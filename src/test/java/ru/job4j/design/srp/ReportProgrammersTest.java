package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportProgrammersTest {
    @Test
    public void whenGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProgrammers(store);
        String ls = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(ls).append("<head>").append(ls).append("<title>")
                .append(ls).append("Report").append(ls)
                .append("</title>").append(ls).append("</head>").append(ls).append("<body>")
                .append(ls).append("<h1>").append(ls)
                .append("Name; Hired; Fired; Salary;").append(ls).append("</h1>")
                .append(ls).append("<h2>").append(ls)
                .append(worker.getName()).append(" ")
                .append(worker.getHired()).append(" ")
                .append(worker.getFired()).append(" ")
                .append(worker.getSalary()).append(" ").append(ls)
                .append("</h2>").append(ls).append("</body>")
                .append(ls).append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
