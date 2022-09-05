package usersPackage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Вспомогательный класс для записи и чтения из xml файла
 * **/
@XmlRootElement(name = "users")
public class UserList {
    private List<User> users = new ArrayList<>();

    public UserList(List<User> users) {
        this.users = users;
    }

    public UserList() {
    }
    @XmlElement(name = "user")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
