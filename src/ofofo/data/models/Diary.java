package ofofo.data.models;

public class Diary {
    private String id;
    private String userName;
    private String password;

    public Diary() {

    }
    public Diary(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    public String getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "\nDiary {Id: " + id + ", userName: " + userName + ", password: " + password + "}\n";
    }
}
