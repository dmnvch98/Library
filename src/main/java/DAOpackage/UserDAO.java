package DAOpackage;

import XMLpackage.WriterReader;
import usersPackage.User;
import usersPackage.UserList;

import java.util.List;

/**
 * Слой для доступа к информации о пользователях
 * **/
public class UserDAO implements DAO<User> {
    List<User> users;
    WriterReader writerReader = new WriterReader();
    UserList userList;

    public UserDAO() {
        userList = writerReader.readUsersFromXml();
        users = userList.getUsers();
    }

    @Override
    public User get(int id) {
        return null;
    }

    public List<User> getAll() {
        return users;
    }

    @Override
    public void add(User user) {
        if (user != null) {
            users.add(user);
            userList.setUsers(users);
            writerReader.saveToXML(userList);
        }
    }

    @Override
    public void update(User user, List<String> params) {

    }

    @Override
    public void delete(User user) {

    }
}
