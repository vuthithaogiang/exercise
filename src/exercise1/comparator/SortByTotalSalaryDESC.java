package exercise1.comparator;

import exercise1.Employee;

import java.util.Comparator;

public class SortByTotalSalaryDESC implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        if (e2.getTotalSalary() > e1.getTotalSalary()) {
            return 1;
        }
        if (e2.getTotalSalary() < e1.getTotalSalary()) {
            return -1;
        }
        return 0;
    }
}
