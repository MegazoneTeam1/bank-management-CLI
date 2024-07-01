package domain;

public class User {

    private String name;
    private String phoneNumber;
    private String id;
    private String password;

    public User(String name, String phoneNumber, String id, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.password = password;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getId() { return id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
   }
