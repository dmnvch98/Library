package usersPackage;

import DAOpackage.BookDao;
import DAOpackage.UserDAO;
import bookPackage.Book;
import bookPackage.BookService;

import java.util.List;
import java.util.Scanner;

import static utils.UsersUtils.askUserType;
import static utils.Utils.*;

public class UserService {

    Scanner scanner = new Scanner(System.in);
    BookService bookService = new BookService();

    public User register() {
        String userName = askEnterString("%s%5s", "Enter username (minimum 4 characters) : ", "");
        String password = askEnterString("%s%5s", "Enter password (minimum 4 characters) : ", "");
        UserType userType = askUserType();

        return new User(userName, password, userType);
    }

    public User signIn(UserDAO userDAO) {
        String userName = askEnterString("%s%5s", "Enter username (minimum 4 characters) : ", "");
        String password = askEnterString("%s%5s", "Enter password (minimum 4 characters) : ", "");
        List<User> usersList = userDAO.getAll().stream()
                .filter(x -> x.getUsername().equals(userName) && x.getPassword() == password.hashCode()).toList();
        if (usersList.size() == 1) {
            return usersList.get(0);
        } else {
            System.out.println("WARNING: User doesn't exist");
            return null;
        }
    }

    public void addBook(User user, BookDao BookDao) {
        if (user != null && user.getUserType().equals(UserType.ADMIN)) {
            BookDao.create(bookService.createBook());
        } else {
            System.out.println("WARNING: Not allowed. You are not admin");
        }
    }

}
