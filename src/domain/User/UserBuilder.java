package domain.User;

public class UserBuilder {
    private String name;
    private String phoneNumber;
    private String id;
    private String password;

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder id(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(name, phoneNumber, id, password);
    }
}
