package exercise1;

import java.util.Date;

public class Employee extends Person{
    private static  int nextId = 1001;
    private String empId;
    private String duty;
    private float salary;
    private float experience;
    private float workingDay;
    private float totalSalary;
    private float bonus;

    public Employee() {

    }

    public Employee(String empId, String duty, float salary, float experience, float workingDay,
                    float totalSalary, float bonus){
        setEmpId(empId);
        this.duty = duty;
        this.salary = salary;
        this.experience = experience;
        this.workingDay = workingDay;
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public Employee(String id, String fullName, String address, Date dateOfBirth,
                    String email, String phoneNumber, String empId, String duty,
                    float salary, float experience, float workingDay,
                    float totalSalary, float bonus){
        super(id, fullName, address, dateOfBirth, email,phoneNumber );
        setEmpId(empId);
        this.duty = duty;
        this.salary = salary;
        this.experience = experience;
        this.workingDay = workingDay;
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public final static void setNextId(int nextId){
        Employee.nextId = nextId;
    }
    public final String getEmpId() {
        return empId;
    }

    public final void setEmpId(String empId) {
       if(empId == null){
           this.empId = "EMP" + nextId;
           nextId++;
       }
       else{
           this.empId = empId;
       }
    }

    public final String getDuty() {
        return duty;
    }

    public final void setDuty(String duty) {
        this.duty = duty;
    }

    public final float getSalary() {
        return salary;
    }

    public final void setSalary(float salary) {
        this.salary = salary;
    }

    public final float getExperience() {
        return experience;
    }

    public final void setExperience(float experience) {
        this.experience = experience;
    }

    public final float getWorkingDay() {
        return workingDay;
    }

    public final void setWorkingDay(float workingDay) {
        this.workingDay = workingDay;
    }

    public final float getTotalSalary() {
        return totalSalary;
    }

    public final void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public final float getBonus() {
        return bonus;
    }

    public final void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public void calculateSalary() {
        totalSalary = workingDay * salary / 22 + bonus;
    }

    public void calculBonus() { //
        if (workingDay >= 20) {
            var bonusDay = workingDay - 20;
            bonus = bonusDay * 0.5f * salary / 22;
        } else {
            bonus = 0;
        }
    }

    public void receiveSalary() {
        System.out.println("Mức lương chuyển khoản của nhân viên "
                + getFullNameString() + ": " + totalSalary);
    }

    public String receiBonus() {
        return "Nhận tiền mặt";
    }
}
