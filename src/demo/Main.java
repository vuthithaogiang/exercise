package demo;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {

    public static void main (String[] args){
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        LocalDate ld1 = ld.plusDays(2);
        String dob = "2000-04-05";
        LocalDate ld4 = LocalDate.parse(dob);
        System.out.println(ld4.getDayOfWeek());

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
    }
}
