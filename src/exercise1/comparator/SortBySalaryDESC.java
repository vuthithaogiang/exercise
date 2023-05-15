package exercise1.comparator;

import exercise1.Employee;

import java.util.Comparator;

public class SortBySalaryDESC implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        if(e2.getSalary() > e1.getSalary() ) {
            return 1;
        }
        if(e2.getSalary() < e1.getSalary()) {
            return -1;
        }
        return 0;
    }
}
