package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {

    private Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        List<Employee> employeeList = store.findBy(filter);
        employeeList.sort(new SortBySalaryDesc());
        for (Employee employee : employeeList) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
