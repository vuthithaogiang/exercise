package practice_interface;

import java.util.ArrayList;

public class AccountManagermentImp implements AccountManagerment{
    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountManagermentImp() {
        accounts = new ArrayList<>();
    }

    public AccountManagermentImp(ArrayList<Account> accounts){
        this.accounts = accounts;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts){
        this.accounts = accounts;
    }

    private boolean isExist(Account account){
        for(var acc : accounts){
            if(acc.getUsername().compareTo(account.getUsername()) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean signup(Account account) {
       if(!isExist(account)){
           this.accounts.add(account);
           return true;
       }
       return false;
    }

    @Override
    public boolean login(Account account) {
      for(int i = 0 ; i < accounts.size(); i ++ ){
          if(accounts.get(i).equals(account) && accounts.get(i) instanceof ActiveAccount == true ){
              System.out.println("true!!!");
              var activeAcc = (ActiveAccount) accounts.get(i);
              activeAcc.setOnline(true);
              return true;
          }
          else if(accounts.get(i) instanceof ActiveAccount == false){
              System.out.println("false!!!");

          }
      }
      return false;
    }

    @Override
    public void logout(Account account) {
       // turn on: active = false
        for(int i = 0; i < accounts.size(); i ++) {
            if(accounts.get(i).equals(account) &&
            accounts.get(i) instanceof ActiveAccount){
                var activeAcc = (ActiveAccount) accounts.get(i);
                activeAcc.setOnline(false);
                break;
            }
        }
    }

    @Override
    public boolean removeAccount(Account account) {
        for(int i = 0; i < accounts.size(); i ++) {
            if(account.equals(accounts.get(i))){
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Phương thức kích hoạt lại tài khoản đag bị vô hiệu hóa:
     * điều kiện active tk là nhập đúng mật khẩu và tài khoản chưa bị xóa khỏi hệ thống
     * @param account
     * @return
     */
    @Override
    public boolean recoverAccount(Account account) {
        for(int i = 0; i < accounts.size(); i ++) {
            if(accounts.get(i).equals(account) &&
            accounts.get(i) instanceof ActiveAccount) {
                var activeAcc = (ActiveAccount) accounts.get(i);
                activeAcc.setActive(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changePassword(Account account) {
        for(int i = 0; i < accounts.size() ; i ++) {
            var acc = accounts.get(i);
            if(acc.equals(account)){
                acc.setPassword(account.getPassword());
                return true;
            }
        }
        return false;
    }

    @Override
    public void changeAccountInfo(Account account) {
       for(int i = 0 ; i < accounts.size(); i ++) {
           var acc = accounts.get(i);
           if(acc.equals(account)){
               acc.setEmail(account.getEmail());
               acc.setPhoneNumber(account.getPhoneNumber());
               //...

               break;
           }
       }
    }
}
