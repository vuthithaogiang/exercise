package exercise1.comparator;

import exercise1.Employee;

import java.util.Comparator;

public class SortByNameASC implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        return e1.getFullName().getFirst().compareTo(e2.getFullName().getFirst());
    }
}
