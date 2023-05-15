package exercise1.comparator;

import exercise1.Employee;

import java.util.Comparator;

public class SortByNameDESC implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        return e2.getFullName().getFirst().compareTo(e2.getFullName().getFirst());
    }
}
