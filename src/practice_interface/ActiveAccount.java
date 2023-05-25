package practice_interface;

public class ActiveAccount extends Account {

    private boolean active;
    private boolean online;


    public ActiveAccount( Account account, boolean active ) {
        super(account.getId(), account.getUsername(), account.getPassword());
        this.active = active;

    }

    public boolean isActive() {
        return  active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online){
        this.online = online;
    }

}
