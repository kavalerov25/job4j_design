package ru.job4j.design.srp;

import java.util.Comparator;

public class SortBySalaryDesc implements Comparator<Employee> {
    @Override
    public int compare(Employee empolyee1, Employee empolyee2) {
        return (int) (empolyee2.getSalary() - empolyee1.getSalary());
    }
}
