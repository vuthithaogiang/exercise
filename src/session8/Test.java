package session8;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        var choice = 0;
        var input = new Scanner(System.in);

        Room room = new Room("T12", "HN"); //room default
        ArrayList<Person> listPerson = new ArrayList<>();
        room.setListPerson(listPerson);

        do {
            System.out.println("=========================");
            System.out.println("1. Add  person in room");
            System.out.println("2. Remove person by name in room.");
            System.out.println("3. Show information's room");
            System.out.println("4. Sort people in room by ascending name");
            System.out.println("0. Exit");
            System.out.println("===========================");

            System.out.println("Your choice? ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 0:
                    System.out.println("Thanks!!!");
                    break;
                case 1:
                    Person p = createNewPerson(input);
                    room.addPersonInRoom(p);
                    System.out.println("Add person complete!!");
                    break;
                case 2:
                    System.out.println("Enter name's person that you want to delete: ");
                    var name = input.nextLine();

                    Person person = findPersonByName(room.getListPerson(), name);
                    if(person != null) {
                        room.removePersonInRoom(person);
                        System.out.println("Remove person " + name + " complete!!!");
                    }
                    break;
                case 3:
                    room.showInfoRoom();
                    break;
                case 4:
                    room.sortPersonInRoomByName();
                    System.out.println("Room after sorted: ");
                    room.showInfoRoom();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;

            }
        }
        while(choice != 0);

    }

    private static Person createNewPerson(Scanner input){
        System.out.println("Enter name: ");
        var name = input.nextLine();
        System.out.println("Enter age: ");
        var age = input.nextInt();
        input.nextLine();
        System.out.println("Enter telephone: ");
        var telephone = input.nextLine();
        System.out.println("Enter address: ");
        var address = input.nextLine();

        Person p = new Person(name, age, telephone, address);
        return p;
    }

    private static Person findPersonByName(ArrayList<Person> people, String name){
        for(int i =0 ; i< people.size(); i++) {
            if(people.get(i).getName().compareTo(name) == 0){
                return people.get(i);
            }
        }
        return null;
    }
}
