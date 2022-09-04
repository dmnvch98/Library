package usersPackage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String username;
    private int password;

    private UserType userType;

    public User(String username, String password, usersPackage.UserType userType) {
        this.username = username;
        this.password = password.hashCode();
        this.userType = userType;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }
    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }
    @XmlElement
    public void setPassword(int password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }
    @XmlElement
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", userType=" + userType +
                '}';
    }
}
