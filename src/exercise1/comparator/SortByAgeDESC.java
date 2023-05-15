package exercise1.comparator;

import exercise1.Employee;

import java.util.Comparator;

public class SortByAgeDESC implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        if(e2.getDateOfBirth().getTime() > e1.getDateOfBirth().getTime()){
            return 1;
        }
        if(e2.getDateOfBirth().getTime() < e1.getDateOfBirth().getTime()) {
            return -1;
        }
        return 0 ;
    }
}
