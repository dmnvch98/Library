package DAOpackage;

import XMLpackage.WriterReader;
import usersPackage.User;
import usersPackage.UserList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAO implements DAO<User> {
    Set<User> users = new HashSet<>();
    WriterReader writerReader = new WriterReader();
    UserList userList = new UserList();

    public UserDAO() {
        userList = writerReader.readUsersFromXml();
        users = userList.getUsers();
    }

    @Override
    public User get(int id) {
        return null;
    }

    public Set<User> getAll() {
        return users;
    }

    @Override
    public void add(User user) {
        users.add(user);
        userList.setUsers(users);
        writerReader.saveToXML(userList);
    }

    @Override
    public void update(User user, List<String> params) {

    }

    @Override
    public void delete(User user) {

    }
}
