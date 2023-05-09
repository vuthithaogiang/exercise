package session10;

public abstract class Phone {
     public abstract void insertPhone(String name, String phone);
     public abstract void removePhone(String name);
     public abstract void updatePhone(String name, String phone, String newPhone);
     public abstract PhoneNumber searchPhone(String name);
     public abstract void sort();
}
