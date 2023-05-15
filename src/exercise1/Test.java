package exercise1;

import exercise1.comparator.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){
          String empFile = "EMP.DAT";
          int choice;
          ArrayList<Employee> employees = new ArrayList<>(readEmpFromFile(empFile));

          updateEmployeeId(employees);
          var input = new Scanner(System.in);

          do{
              System.out.println("=============== MENU ==================");
              System.out.println("1. Add new employee.");
              System.out.println("2. Display information employees");
              System.out.println("3. Write information employees to file.");
              System.out.println("4. Search information employees by first name.");
              System.out.println("5. Search information employees have salary >= x.");
              System.out.println("6. Search information managers by term.");
              System.out.println("7. Remove employee by emp id");
              System.out.println("8. Calculate bonus");
              System.out.println("9. Calculate total salary");
              System.out.println("10. Sort list employees");
              System.out.println("11. Display bonus and receive bonus");
              System.out.println("12. Display table of salary");
              System.out.println("0. Exit");
              System.out.println("=========================================");

              System.out.println("Your choice? ");
              choice = input.nextInt();
              input.nextLine();

              switch (choice){
                  case 0:
                      System.out.println("Thank!!!");
                      break;
                  case 1:
                      System.out.println("1. Enter 1 to add employee.");
                      System.out.println("2. Enter 2 to add manager.");
                      System.out.println("Please enter: ");
                      var slot = Integer.parseInt(input.nextLine());

                      if(slot == 1){
                          var emp = createNewEmployee(input);
                          employees.add(emp);
                      }
                      else if(slot == 2){
                          var manager = createManager(input);
                          employees.add(manager);
                      }
                      break;
                  case 2:
                     if(employees.size() > 0) {
                         showEmployees(employees);

                     }
                      else{
                         System.out.println("List emp is empty!!!");
                     }
                      break;

                  case 3:
                      if (employees.size() > 0) {
                          var isSuccess = writeEmpToFile(employees, empFile);
                          if (isSuccess) {
                              showMessage("Write file complete!");
                          } else {
                              showMessage("Write file cancel!");
                          }
                      } else {
                          showMessage("List employees is empty. Write file cancel!");
                      }
                      break;
                  case 4:
                      if(employees.size() > 0 ){
                          var name = "";
                          System.out.println("Enter first name that you want to find: ");
                          name = input.next();
                          input.nextLine();

                          var result = searchByName(employees, name);
                          if(result.size()> 0) {
                              System.out.println("Find " + result.size() + " employee(s) in list: ");
                              showEmployees(result);
                          }
                          else{
                              System.out.println("Do not find employee has first name: " + name
                              + " in list.");
                          }

                      }
                      else{
                          showMessage("List employees is empty!!!");
                      }
                      break;
                  case 5:
                      if(employees.size() > 0) {
                          System.out.println("Enter salary that you want to search: ");
                          var salary = Float.parseFloat(input.nextLine());

                          var result = searchBySalary(employees, salary);
                          if(result.size() > 0 ){
                              System.out.println("Find " + result.size() + " employee(s) in list: ");
                              showEmployees(result);
                          }
                          else{
                              System.out.println("Do not find employee has salary >= : " + salary
                                      + " in list.");
                          }
                      }

                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                  case 6:
                      if(employees.size() > 0){
                          System.out.println("Enter the start year of term (ex: 2020): ");
                          var startYear = Integer.parseInt(input.nextLine());

                          System.out.println("Enter the end year of term (ex: 2020): ");
                          var endYear = Integer.parseInt(input.nextLine());

                          var result = findMangerByTerm(employees, startYear, endYear);

                          if(result.size() > 0 ){
                              System.out.println("Find " + result.size() + " employee(s) in list: ");
                               showManagers(result);
                          }
                          else{
                              System.out.println("Do not find employee has term in [ " + startYear + " , "
                                      + endYear
                                      + " ] in list.");
                          }

                      }
                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                  case 7:
                      if(employees.size() > 0){
                          System.out.println("Enter ID employee that you want to remove: ");
                          var id = input.nextLine();

                          var removeSuccess = removeEmployeeById(employees, id);
                          if(removeSuccess){
                              System.out.println("Remove employee has ID: " + id + " complete!!!");
                          }
                          else{
                              System.out.println("Remove failed!!!");
                          }
                      }
                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                  case 8:
                      if(employees.size() > 0){

                          calculateBonus(employees);
                      }
                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                  case 9:
                      if(employees.size() > 0){
                            calculateTotalSalary(employees);
                      }
                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                  case 10:
                      if(employees.size() > 0){

                          System.out.println("1. Name ascending to a - z.");
                          System.out.println("2. Name descending to z -a.");
                          System.out.println("3. Salary ascending.");
                          System.out.println("4. Salary descending.");
                          System.out.println("5. Number of year experience ascending");
                          System.out.println("6. Number of year experience descending.");
                          System.out.println("7. Age ascending.");
                          System.out.println("8. Age descending.");
                          System.out.println("9. Total salary descending.");
                          var option = Integer.parseInt(input.nextLine());
                          sortEmployees(employees, option);
                          showMessage("List employees after sorted by option: " + option);
                          showEmployees(employees);
                      }
                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                  case 11:
                      if(employees.size() > 0){
                          showMessage("Bonus's employees: ");
                         showBonus(employees);
                      }
                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                  case 12:
                      if(employees.size() > 0){
                           showMessage("Payroll's employees: ");
                          showPayroll(employees);
                      }
                      else{
                          System.out.println("List employee is empty!!!");
                      }
                      break;
                   default:
                      System.out.println("Invalid choice!!");
                      break;
              }
          }while(choice != 0);
    }

    public static void showPayroll(ArrayList<Employee> emps){
        System.out.printf("%-15s%-25s%-15s%-15s%-15s%-15s\n",
                "Emp ID", "Name", "Salary", "Working Day", "Bonus", "Total Salary");

        for(var emp : emps){
            System.out.printf("%-15s%-25s%-15.2f%-15.2f%-15.2f%-15.2f\n",
                    emp.getEmpId(), emp.getFullNameString(), emp.getSalary(),
                    emp.getWorkingDay(), emp.getBonus(), emp.getTotalSalary());
        }
    }

    public static void showBonus(ArrayList<Employee> emps){

        System.out.printf("%-15s%-25s%-15s%-25s\n",
                "Emp ID", "Name", "Bonus", "Receipt Bonus");

        for(var emp : emps){
            System.out.printf("%-15s%-25s%-15.2f%-25s\n",
                    emp.getEmpId(), emp.getFullNameString(), emp.getBonus(), emp.receiBonus());
        }
    }
    public static void sortEmployees(ArrayList<Employee> emps, int option){
        switch (option){
           case 1 -> emps.sort(new SortByNameASC());
           case 2 -> emps.sort(new SortByNameDESC());
           case 3 -> emps.sort(new SortBySalaryASC());
           case 4 -> emps.sort(new SortBySalaryDESC());
           case 5 -> emps.sort(new SortByExperienceASC());
           case 6 -> emps.sort(new SortByExperienceDESC());
           case 7 -> emps.sort(new SortByAgeASC());
           case 8 -> emps.sort(new SortByAgeDESC());
           case 9 -> emps.sort(new SortByTotalSalaryDESC());
           default -> System.out.println("Invalid option!!!!");
        }
    }
    private static void calculateTotalSalary(ArrayList<Employee> emps){
        for (var emp: emps) {
            emp.calculateSalary();
        }
    }

    private static void calculateBonus(ArrayList<Employee> emps){
        for(var emp : emps) {
            emp.calculBonus();
        }
    }
    private static boolean removeEmployeeById(ArrayList<Employee> emps, String id){
        for(int i = 0;i < emps.size(); i ++){
            if(emps.get(i).getEmpId().compareTo(id) == 0) {
                emps.remove(i);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Employee> findMangerByTerm(ArrayList<Employee> emps,
                                                        int startYear, int endYear){
        ArrayList<Employee> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        for(var emp : emps) {
            if(emp instanceof Manager ){
                var manager = (Manager) emp;
                calendar.setTime(manager.getStartDate());
                var start = calendar.get(Calendar.YEAR);
                calendar.setTime(manager.getEndDate());
                var end = calendar.get(Calendar.YEAR);

                if(start <= startYear && end >= endYear){
                    result.add(manager);
                }
            }
        }
        return result;
    }
    private static ArrayList<Employee> searchBySalary(ArrayList<Employee> emps, float salary){
        ArrayList<Employee> res = new ArrayList<>();
        for(var emp : emps){
            if(emp.getSalary() >= salary){
                res.add(emp);
            }
        }
        return res;
    }

    private static ArrayList<Employee> searchByName(ArrayList<Employee> emps, String name){
        ArrayList<Employee> res = new ArrayList<>();
        for(var emp: emps){
            var firstName = emp.getFullName().getFirst();
            if(firstName.compareToIgnoreCase(name) == 0){
                res.add(emp);
            }
        }
        return res;
    }
    private static void showEmployees(ArrayList<Employee> employees){
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        showMessage("List employees: ");

        System.out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Address", "Dob", "Email", "Phone", "Emp ID",
                "Duty", "Salary", "Experience", "Working day");

        for(var emp : employees ){
            showEmp(emp, dateFormat);
        }
    }

    private static  void showEmp(Employee emp, SimpleDateFormat dateFormat){
        System.out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15.2f%-15.2f%-15.2f\n",
                emp.getId(),
                emp.getFullNameString(),
                emp.getAddress(),
                dateFormat.format(emp.getDateOfBirth()),
                emp.getEmail(),
                emp.getPhoneNumber(),
                emp.getEmpId(),
                emp.getDuty(),
                emp.getSalary(),
                emp.getExperience(),
                emp.getWorkingDay()
               );
    }

    private static void showManagers(ArrayList<Employee> managers){
        if(managers.size() > 0) {
            var format = "dd/MM/yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            System.out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s"  +
                            "%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    "ID", "Name", "Address", "Dob", "Email", "Phone",
                    "Emp ID", "Duty", "Salary", "Bonus", "Experience",
                    "Working day", "Bonus", "Total Salary", "Start Date",
                    "End Date");

            for(var emp : managers) {
                if(emp instanceof Manager) {
                    var m = (Manager) emp;
                    showManager(m, dateFormat);
                }
            }
        }
        else{
            showMessage("List manager is empty!!!");
        }
    }

    private static void showManager(Manager manager, SimpleDateFormat dateFormat){
        System.out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s" +
                        "%-15s%-15.2f-%15.2f-%15.2f-%15.2f-%15.2f-%15.2f-%15s%-15s\n",
                manager.getId(), manager.getFullNameString(),
                manager.getAddress(),
                dateFormat.format(manager.getDateOfBirth()),
                manager.getEmail(), manager.getPhoneNumber(),
                manager.getEmpId(), manager.getDuty(),
                manager.getSalary(), manager.getBonus(),
                manager.getExperience(), manager.getWorkingDay(),
                manager.getBonus(), manager.getTotalSalary(),
                dateFormat.format(manager.getStartDate()),
                dateFormat.format(manager.getEndDate()));
    }

    private static void showMessage(String msg) {
        System.out.println("====> " + msg + "<=====");
    }

    private static void updateEmployeeId(ArrayList<Employee> employees){
        int maxId = 1000;
        for(var emp : employees){

            var curId = Integer.parseInt(emp.getEmpId().substring(3));
            if(curId > maxId) {
                maxId = curId;
            }
        }
        Employee.setNextId(maxId + 1);
    }

    private static boolean writeEmpToFile(ArrayList<Employee> employees, String fileName){
        try{
            PrintWriter printWriter = new PrintWriter(fileName);
            var format = "dd/MM/yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            for(var emp: employees){
                if(emp instanceof Manager) {
                    printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%f-%f-%f-%f-%f-%s-%s\n",
                            emp.getId(), emp.getFullNameString(), emp.getAddress(),
                            dateFormat.format(emp.getDateOfBirth()), emp.getEmail(),
                            emp.getPhoneNumber(), emp.getEmpId(), emp.getDuty(),
                            emp.getSalary(), emp.getExperience(), emp.getWorkingDay(),
                            emp.getTotalSalary(), emp.getBonus(),
                            dateFormat.format(((Manager) emp).getStartDate()),
                            dateFormat.format(((Manager) emp).getEndDate()));
                }
                else{
                    printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%f-%f-%f-%f-%f\n",
                            emp.getId(), emp.getFullNameString(), emp.getAddress(),
                            dateFormat.format(emp.getDateOfBirth()), emp.getEmail(),
                            emp.getPhoneNumber(), emp.getEmpId(), emp.getDuty(),
                            emp.getSalary(), emp.getExperience(), emp.getWorkingDay(),
                            emp.getTotalSalary(), emp.getBonus()
                            );

                }
            }

            printWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static ArrayList<Employee> readEmpFromFile(String fileName){
        ArrayList<Employee> employees = new ArrayList<>();
        var file = new File(fileName);
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
         try{
             file.createNewFile();
             var input = new Scanner(file);
             while(input.hasNextLine()){
                 var line = input.nextLine();
                 var data = line.split("-");
                 Employee employee = createEmpFormData(data, dateFormat);

                 if(employee != null){
                     employees.add(employee);
                 }
             }

             input.close();
         }
         catch (IOException e){
             e.printStackTrace();
         }
         return employees;
    }

    private static Employee createEmpFormData(String[] data, SimpleDateFormat dateFormat){
        var id = data[0];
        var fullName = data[1];
        var address = data[2];
        Date dob = null;
        try{
            dob = dateFormat.parse(data[3]);
        }
        catch (ParseException e){
            e.printStackTrace();
        }


        var email = data[4];
        var phoneNumber = data[5];
        var empId = data[6];
        var duty = data[7];
        var salary = Float.parseFloat(data[8]);
        var experience = Float.parseFloat(data[9]);
        var workingDay = Float.parseFloat(data[10]);
        var totalSalary = Float.parseFloat(data[11]);
        var bonus = Float.parseFloat(data[12]);
        Date start;
        Date end;
        if(data.length > 13){
            try{
                start = dateFormat.parse(data[13]);
                end = dateFormat.parse(data[14]);
                return  new Manager(id, fullName, address, dob,  email, phoneNumber, empId,
                        duty, salary, experience, workingDay, totalSalary, bonus, start, end );

            }
            catch (ParseException e){
                e.printStackTrace();
            }
        }
        else{
            return new Employee(id, fullName, address, dob, email, phoneNumber, empId,
                    duty, salary, experience, workingDay, totalSalary, bonus);
        }
        return  null;
    }

    private static Manager createManager(Scanner input){
        Employee emp = createNewEmployee(input);
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        System.out.println("Enter start date (dd/MM/yyyy): ");
        Date start = null;
        try{
            start = dateFormat.parse(input.nextLine());
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        Date end = null;
        System.out.println("Enter end date (dd/MM/yyyy): ");
        try{
            end = dateFormat.parse(input.nextLine());
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        return new Manager(emp, start, end);
    }

    private static Employee createNewEmployee(Scanner input){
        System.out.println("Enter id: ");
        var pId = input.nextLine();

        System.out.println("Enter full name: ");
        var name = input.nextLine();

        System.out.println("Enter address: ");
        var address = input.nextLine();

        System.out.println("Enter phone number: ");
        var phoneNumber = input.nextLine();

        System.out.println("Enter email: ");
        var email = input.nextLine();

        System.out.println("Enter date of birth (dd/MM/yyyy): ");
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date dob;
        try{
            dob = dateFormat.parse(input.nextLine());
        }
        catch (ParseException p){
            p.printStackTrace();
            dob = new Date();
        }

        System.out.println("Enter your duty: ");
        var duty = input.nextLine();

        System.out.println("Enter salary: ");
        var salary = Float.parseFloat(input.nextLine());


        System.out.println("Enter number of years experience: ");
        var experience = Float.parseFloat(input.nextLine());

        System.out.println("Enter number of day working: ");
        var workingDay = Float.parseFloat(input.nextLine());

        return new Employee(pId, name, address, dob, email, phoneNumber, null, duty,
                salary, experience, workingDay, 0 , 0);
    }
}
