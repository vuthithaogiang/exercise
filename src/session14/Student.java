package session14;

public class Student {
    private int id;
    private String name;
    private String dateOfBirth;
    private String address;
    private float gpa;

    public Student() {

    }

    public Student(String name, String dateOfBirth, String address, float gpa)  throws InvalidGradeException{
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        setGpa(gpa);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) throws InvalidGradeException {
       if(gpa >=0 && gpa <= 10){
           this.gpa = gpa;
       }
       else{
           this.gpa = 0;
           var msg = "You enter the GPA invalid!!!";
           throw new InvalidGradeException(msg, gpa);

       }
    }

    public void showStudent() {
        System.out.printf("%-15d%-25s%-25s%-25s%-20.2f\n",
                this.getId(), this.getName(), this.getDateOfBirth(), this.getAddress(), this.getGpa());
    }


}
