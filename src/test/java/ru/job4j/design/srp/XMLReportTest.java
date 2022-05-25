package ru.job4j.design.srp;

import org.junit.Test;

import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class XMLReportTest {

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        GregorianCalendar dateHired = new GregorianCalendar(2022, Calendar.MAY, 23);
        GregorianCalendar dateFired = new GregorianCalendar(2022, Calendar.MAY, 25);
        dateHired.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        dateFired.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        Employee worker = new Employee("Ivan", dateHired, dateFired, 100);
        store.add(worker);
        Report xml = new XMLReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n<employees>")
                .append("\n    <employees name=\"").append(worker.getName()).append("\"")
                .append(" hired=\"")
                .append("2022-05-23T00:00:00+03:00")
                .append("\" fired=\"")
                .append("2022-05-25T00:00:00+03:00")
                .append("\" salary=\"").append(worker.getSalary())
                .append("\"/>")
                .append("\n</employees>\n");
        assertThat(xml.generate(em -> true), is(expect.toString()));
    }
}