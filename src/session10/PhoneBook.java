package session10;

import java.util.ArrayList;

public class PhoneBook extends Phone{
    private ArrayList<PhoneNumber> phoneList = new ArrayList<>();

    public ArrayList<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    public PhoneBook() {

    }

    public PhoneBook(String name , String phone) {
        PhoneNumber p = new PhoneNumber(name, phone);
        if(!this.phoneList.contains(p)){
            this.phoneList.add(0, p);
        }
    }

    @Override
    public  void insertPhone(String name, String phone){
        System.out.println(this.phoneList.size() );
        if(this.phoneList.size() == 0 ) {
            PhoneNumber p = new PhoneNumber(name, phone);
            this.phoneList.add(p);
            System.out.println("Insert complete!!");
            return;
        }

        for(int i = 0; i < this.phoneList.size()  ; i++) {
            if(this.phoneList.get(i).getName().compareTo(name) == 0) {
                if(!this.phoneList.get(i).getPhoneList().contains(phone)) {
                    PhoneNumber p = new PhoneNumber(name, phone);
                    this.phoneList.add(0, p);
                    System.out.println("Insert complete!!");
                    return;
                }
                else {
                    System.out.println("This phone number and user is exist!");
                    return;
                }
            }
        }
        // ngoai for khong co name trung
        PhoneNumber p = new PhoneNumber(name, phone);
        this.phoneList.add(p);
        System.out.println("Insert complete!!");
        return;
    }
    @Override
    public  void removePhone(String name){
        for( int i = 0; i < this.phoneList.size(); i ++) {
            if(this.phoneList.get(i).getName().compareTo(name) == 0){
                this.phoneList.remove(this.phoneList.get(i));
                System.out.println("Remove complete!");
                return;
            }
        }
        System.out.println("Remove failed!!!");
    }
    @Override
    public  void updatePhone(String name, String phone, String newPhone){
        for(int i = 0; i < this.phoneList.size() ; i++ ){
            if(this.phoneList.get(i).getName().compareTo(name) == 0
                    && this.phoneList.get(i).getPhoneList().contains(phone)){
              this.phoneList.get(i).getPhoneList().remove(phone);
              this.phoneList.get(i).getPhoneList().add(newPhone);
              System.out.println("Update complete!");
              return;
            }
        }
    }
    @Override
    public  PhoneNumber searchPhone(String name){
        for(int i = 0; i < this.phoneList.size() ; i++ ){
            if(this.phoneList.get(i).getName().compareTo(name) == 0){
                return this.phoneList.get(i);
            }
        }
        return null;
    }

    @Override
    public  void sort(){
       this.phoneList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

    }
    public void showInfo() {
        System.out.printf("%-15s%-15s\n", "Name", "Phone number");
        for( int i = 0 ; i < this.phoneList.size() ; i ++ ) {
           this.phoneList.get(i).showInfoPhoneNumber();
        }
    }
}
