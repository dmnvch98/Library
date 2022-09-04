import DAOpackage.BookDaoXml;
import DAOpackage.DAO;
import DAOpackage.UserDAO;
import bookPackage.Book;
import bookPackage.BookService;
import usersPackage.User;
import usersPackage.UserService;
import utils.Utils;

import java.util.Optional;

public class Executor {
    static BookDaoXml bookDao = new BookDaoXml();
    static UserDAO userDAO = new UserDAO();
    static UserService userService = new UserService();
    static BookService bookService = new BookService();
    static private User currentUser;

    public static void main(String[] args) {
        //bookDao = new BookDaoXml();

        // currentUser = userService.signIn(userDAO);
        // userService.addBook(currentUser, bookDao);
        new Executor().init();
    }

    public void init() {
        while (true) {
            //System.out.println("Current user: " + Optional.ofNullable(currentUser).orElse("none"));
            int enteredNumber = Utils.askEnterNumberInRange(
                    "Select action:\n" +
                            "1 - Registration\n" +
                            "2 - Sign in\n" +
                            "3 - Add Book\n" +
                            "4 - Get all books\n" +
                            "5 - Get book by name\n" +
                            "Exit - any key\n" +
                            "Enter number: ", 1, 5);
            switch (enteredNumber) {
                case 1 -> userDAO.create(userService.register());
                case 2 -> currentUser = userService.signIn(userDAO);
                case 3 -> userService.addBook(currentUser, bookDao);
                case 4 -> System.out.println(bookDao.getAll());
                case 5 -> System.out.println(bookService.getBookByName(bookDao, Utils.askEnterString("%s%5s","Enter book name: ", "")));
                default -> {
                    return;
                }
            }
        }
    }

}
