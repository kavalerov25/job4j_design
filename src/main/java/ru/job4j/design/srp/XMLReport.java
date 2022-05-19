package ru.job4j.design.srp;

import java.util.function.Predicate;

public class XMLReport implements Report {
    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<Employees>");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("<Employee>")
                    .append("<Name>")
                    .append(employee.getName())
                    .append("</Name>")
                    .append("<Salary>")
                    .append(employee.getSalary())
                    .append("</Salary>")
                    .append("</Employee>");
        }
        text.append("</Employees>");
        return text.toString();
    }
    }
