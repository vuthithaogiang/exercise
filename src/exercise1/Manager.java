package exercise1;

import java.util.Date;

public class Manager extends Employee{
    private Date startDate;
    private Date endDate;

    public Manager() {

    }

    public Manager(Employee emp, Date startDate, Date endDate){
        super(emp.getId(), emp.getFullNameString(), emp.getAddress(),
                emp.getDateOfBirth(), emp.getEmail(), emp.getPhoneNumber(),
                emp.getEmpId(), emp.getDuty(), emp.getSalary(), emp.getExperience(),
                emp.getWorkingDay(), emp.getTotalSalary(), emp.getBonus());
        this.startDate =startDate;
        this.endDate = endDate;
    }

    public Manager(String empId, String duty, float salary, float experience,
                   float workingDay, float totalSalary, float bonus, Date startDate,
                   Date endDate){
        super(empId, duty, salary, experience, workingDay, totalSalary, bonus );
        this.startDate =startDate;
        this.endDate = endDate;
    }

    public Manager(String id, String fullName, String address, Date dateOfBirth,
                   String email, String phoneNumber, String empId, String duty,
                   float salary, float experience, float workingDay, float totalSalary,
                   float bonus, Date startDate, Date endDate){
        super(id, fullName, address, dateOfBirth, email, phoneNumber, empId,
               duty, salary, experience, workingDay, totalSalary, bonus );
        this.startDate =startDate;
        this.endDate = endDate;
    }

    @Override
    public void calculBonus(){
        if (getWorkingDay() >= 22) {
            setBonus(getTotalSalary() * 1.25f);
        } else {
            setBonus(0);
        }
    }

    @Override
    public void receiveSalary() {
        System.out.println("Giám đốc nhận mức lương: " + getTotalSalary());
    }

    @Override
    public String receiBonus() {
        return "Nhận cổ phiếu";
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
