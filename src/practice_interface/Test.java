package practice_interface;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Account account1 = new Account("123", "username", "password");
        var managermentAccount = new AccountManagermentImp();
        // managermentAccount.signup(account1);
         if(managermentAccount.signup(account1) == true){
             System.out.println("sign up complete!");
         }
         else{
             System.out.println("fail!!1");
         }
        System.out.println(managermentAccount.getAccounts().get(0).getUsername());
        System.out.println(account1.equals(managermentAccount.getAccounts().get(0)));
         if(managermentAccount.login(account1) == true){
             System.out.println(account1.getUsername() + " is being online!!");
         }
         else{
             System.out.println("Fail!!");
         }
    }

}
