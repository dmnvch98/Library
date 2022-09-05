package usersPackage;

import DAOpackage.UserDAO;

import java.util.List;

import static utils.Utils.askUserType;
import static utils.Utils.*;

/**
 * Класс авторизации и аутентификации
 * **/
public class UserService {
    public User register(UserDAO userDAO) {
        List<String> credentials = askCredentials();
        List<User> existingUsers = userDAO.getAll();
        if (existingUsers.stream().filter(x -> x.getUsername().equals(credentials.get(0))).toList()
                .size() == 0) {
            return new User(credentials.get(0), credentials.get(1), askUserType());
        } else {
            System.out.println("User with this username already exists");
            return null;
        }
    }

    public User signIn(UserDAO userDAO) {
        List<String> credentials = askCredentials();
        List<User> usersList = userDAO.getAll().stream()
                .filter(x -> x.getUsername()
                        .equals(credentials.get(0)) && x.getPassword() == credentials.get(1).hashCode())
                .toList();
        if (usersList.size() == 1) {
            return usersList.get(0);
        } else {
            System.out.println("WARNING: User doesn't exist");
            return null;
        }
    }

    public boolean authentication(User user) {
        if (user != null) {
            return user.getUserType().equals(UserType.ADMIN);
        } else {
            System.out.println("WARNING: You are not signed in");
            return false;
        }
    }
}
