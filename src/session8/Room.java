package session8;

import java.util.ArrayList;

public class Room {
    private String name;
    private String position;
    private ArrayList<Person> listPerson   = new ArrayList<>();


    public Room() {

    }

    public Room(String name){
        this.name =name;
    }

    public Room(String name, String position) {
        this.name = name;
        this.position= position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<Person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }

    public void addPersonInRoom(Person person) {
        if(!this.listPerson.contains(person)){
            this.listPerson.add(0, person);
        }
        else{
            System.out.println("Do not add this person!!!");
        }
    }

    public void removePersonInRoom(Person p){
        if(this.listPerson.contains(p)){
            this.listPerson.remove(p);
        }
        else{
            System.out.println("Do not remove this person!!!");
        }
    }

    public void showInfoRoom() {
        System.out.printf("%-20s%-20s%-20s%-15s%-20s%-25s\n",
                "Name R", "Position", "Name P", "Age", "Telephone", "Address");
        for(var item: this.listPerson){

            System.out.printf("%-20s%-20s%-20s%-15d%-20s%-25s\n",
                    getName(),
                    getPosition(),
                    item.getName(),
                    item.getAge(),
                    item.getTelephone(),
                    item.getAddress()
                    )
            ;
        }
    }

    public void sortPersonInRoomByName() {
       listPerson.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
    }
}
