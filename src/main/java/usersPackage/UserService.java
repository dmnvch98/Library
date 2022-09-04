package usersPackage;

import DAOpackage.UserDAO;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static usersPackage.UsersUtils.*;

public class UserService {

    Scanner scanner = new Scanner(System.in);

    public User register() {
        String userName = askEnterString("%s%5s", "Enter username (minimum 4 characters) : ", "");
        String password = askEnterString("%s%5s", "Enter password (minimum 4 characters) : ", "");
        UserType userType = askUserType();

        return new User(userName, password, userType);
    }

    public boolean signIn(UserDAO userDAO) {
        String userName = askEnterString("%s%5s", "Enter username (minimum 4 characters) : ", "");
        String password = askEnterString("%s%5s", "Enter password (minimum 4 characters) : ", "");
        Set<User> list = userDAO.getAll();
        int foundUsers = userDAO.getAll().stream()
                .filter(x -> x.getUsername().equals(userName) && x.getPassword() == password.hashCode())
                .toList()
                .size();
        return foundUsers == 1;
    }

}
