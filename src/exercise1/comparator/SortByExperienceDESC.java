package exercise1.comparator;

import exercise1.Employee;

import java.util.Comparator;

public class SortByExperienceDESC implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        if(e2.getExperience() > e1.getExperience()){
            return 1;
        }
        if(e2.getExperience() < e1.getExperience()) {
            return -1;
        }
        return 0;
    }
}
