package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportProgrammers implements Report {
    private final Store store;

    public ReportProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String ls = System.lineSeparator();
        text.append("<html>").append(ls).append("<head>").append(ls).append("<title>")
                .append(ls).append("Report").append(ls)
                .append("</title>").append(ls).append("</head>").append(ls).append("<body>")
                .append(ls).append("<h1>").append(ls)
                .append("Name; Hired; Fired; Salary;")
                .append(ls).append("</h1>")
                .append(ls).append("<h2>").append(ls);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getHired()).append(" ")
                    .append(employee.getFired()).append(" ")
                    .append(employee.getSalary()).append(" ")
                    .append(ls);
        }
        text.append("</h2>").append(ls).append("</body>")
                .append(ls).append("</html>");
        return text.toString();
    }
}