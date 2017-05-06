package Pages.Users;

/**
 * Created by liana on 4/18/17.
 */
public class User {
    private String ID;
    private String username;
    private String status;
    private int BV;

    public User(String ID, String username, String status, int BV){
        this.ID = ID;
        this.username = username;
        this.status = status;
        this.BV = BV;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getBV() {
        return BV;
    }
    public void setBV(int BV) {
        this.BV = BV;
    }
}
