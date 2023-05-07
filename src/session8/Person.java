package session8;

public class Person {
    private String name;
    private int age;
    private String telephone;
    private String address;


    public Person() {

    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name, int age, String telephone, String address){
        this.name= name;
        this.age = age;
        this.telephone = telephone;
        this.address =address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void showInfoPerson() {
        System.out.printf("%-20s%-15d%-20s%-25s\n",
                this.name, this.age, this.telephone, this.address);
    }
}
