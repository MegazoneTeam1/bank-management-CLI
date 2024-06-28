package user;

public class User {
    private String username;
    private String phonenumber;
    private String id;
    private String password;

    public User(String username, String phonenumber, String id, String password) {
        this.username = username;
        this.phonenumber = phonenumber;
        this.id = id;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "이름: " + username + "전화번호: " + phonenumber + "아이디: " + id + "비밀번호: " + password;
    }
}
