package usersPackage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "users")
public class UserList {
    private Set<User> users = new HashSet<>();

    public UserList(Set<User> users) {
        this.users = users;
    }

    public UserList() {
    }
    @XmlElement(name = "user")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
