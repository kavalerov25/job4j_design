package ru.job4j.design.srp;

import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class XMLReportTest {

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report xml = new XMLReport(store);
        String expect = "<Employees>"
                        + "<Employee>"
                        + "<Name>" + worker.getName() + "</Name>"
                        + "<Salary>" + worker.getSalary() + "</Salary>"
                        + "</Employee>"
                        + "</Employees>";
        assertThat(xml.generate(em -> true), is(expect));
    }
}