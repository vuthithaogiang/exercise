package session14;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        var input = new Scanner(System.in);
        var choice = 0;
        do{
            System.out.println("===================================");
            System.out.println("1. Add student.");
            System.out.println("2. Edit student by Id");
            System.out.println("3. Delete student by Id.");
            System.out.println("4. Sort students by GPA.");
            System.out.println("5. Sort students by name");
            System.out.println("6. Show students");
            System.out.println("0. Exit");
            System.out.println("======================================");
            System.out.println("Your choice? ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 0:
                    System.out.println("Thanks!!!!");
                    break;
                case 1:
                    System.out.println("Enter id: ");
                    var id = input.nextInt();

                    var idStudentExisted = findStudentById(students, id);
                    if(idStudentExisted == true){
                        System.out.println("This id is existed. Please enter other id.");
                    }
                    else{
                        Student st = getStudent(input);
                        st.setId(id);

                        students.add(st);

                        System.out.println("Add student complete!!!");
                    }
                     break;
                case 2:
                    if(students.size() > 0) {
                        System.out.println("Enter Id's student that you want to edit: ");
                        var idStudentEdit = input.nextInt();

                        var isExistedStudent = findStudentById(students, idStudentEdit);

                        if(isExistedStudent){
                            editStudentById(students, idStudentEdit);
                        }
                        else{
                            System.out.println("This id is existed. Please enter other id.");
                        }

                    }
                    else{
                        System.out.println("Please add students first!!!");
                    }
                    break;
                case 3:
                    if(students.size() > 0) {
                        System.out.println("Enter id's students that you want to delete: ");
                        var idStudentDelete = input.nextInt();

                        boolean isDeleted = deleteStudentById(students, idStudentDelete);

                        if(isDeleted){
                            System.out.println("Delete student has id: " + idStudentDelete + " complete!!!");
                        }
                        else{
                            System.out.println("Do not find student has id: " + idStudentDelete);
                        }

                    }
                    else{
                        System.out.println("Please add students first!!!");
                    }
                    break;
                case 4:
                    if(students.size() > 0) {
                        sortStudentsByGpaDESC(students);
                        System.out.println("List students after sorted by descending GPA: ");

                        showStudents(students);
                    }
                    else{
                        System.out.println("Please add students first!!!");
                    }
                    break;
                case 5:
                    if(students.size() > 0) {
                      sortStudentByNameASC(students);
                        System.out.println("List students after sorted by ascending name: ");
                        showStudents(students);
                    }
                    else{
                        System.out.println("Please add students first!!!");
                    }
                    break;
                case 6:
                    if(students.size() > 0) {
                        System.out.printf("%-15s%-25s%-25s%-25s%-20s\n",
                                "ID", "Name", "Date of B", "Address", "GPA");
                        showStudents(students);
                    }
                    else{
                        System.out.println("Please add students first!!!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }

        }
        while(choice!=0);
    }


    private static Student getStudent(Scanner input) {
        Student st = new Student();
        input.nextLine();
        System.out.println("Enter name: ");
        var name = input.nextLine();
        System.out.println("Enter date of birth: ");
        var dateOfBirth = input.nextLine();
        System.out.println("Enter address: ");
        var address = input.nextLine();
        System.out.println("Enter GPA: ");
        var gpa = input.nextFloat();
        System.out.println(gpa);


        st.setName(name);
        st.setAddress(address);
        st.setDateOfBirth(dateOfBirth);
        try{
            st.setGpa(gpa);
        }
        catch(InvalidGradeException e) {
            e.printStackTrace(); // in ra thu tu loi goi gay ra ngoai le
        }
        return st;
    }

    private static void showStudents(ArrayList<Student> students) {
        for(var student : students){
            student.showStudent();
        }
    }

    private static boolean findStudentById(ArrayList<Student> students, int id){
        for(var st : students){
            if(st.getId() == id){
                return true;
            }
        }
        return false;
    }

    private static void editStudentById(ArrayList<Student> students, int id){

        for( var st : students){
            if(st.getId() == id){
                var input = new Scanner(System.in);
                System.out.println("Enter new name: ");
                var newName = input.nextLine();
                st.setName(newName);

                System.out.println("Enter new date of birth: ");
                var newDateOfBirth = input.nextLine();
                st.setDateOfBirth(newDateOfBirth);

                System.out.println("Enter new address: ");
                var newAddress = input.nextLine();
                st.setAddress(newAddress);

                System.out.println("Enter new GPA: ");
                var newGpa = input.nextFloat();

                try{
                    st.setGpa(newGpa);
                }
                catch( InvalidGradeException e){
                    e.printStackTrace();
                }
                return;
            }
        }
        return;

    }

    private static boolean deleteStudentById(ArrayList<Student> students, int id){
        for(var item: students) {
            if(item.getId() == id){
                students.remove(item);
                return  true;
            }
        }
        return false;
    }


    private static void sortStudentsByGpaDESC(ArrayList<Student> students) {
       for(int i = 0; i < students.size() - 1; i++) {
           for(int j = students.size() - 1; j > i ; j --){
                if(students.get(j).getGpa() > students.get(j-1).getGpa() ){

                    try{
                        students.get(j-1).setGpa(students.get(j).getGpa());
                        students.get(i).setGpa(students.get(j).getGpa());
                    }
                    catch (InvalidGradeException e){
                        e.printStackTrace();
                    }
                }
           }
       }
    }

    private static void sortStudentByNameASC(ArrayList<Student> students){
        students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

}
