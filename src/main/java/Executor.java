import DAOpackage.BookDao;
import DAOpackage.UserDAO;
import bookPackage.BookService;
import usersPackage.User;
import usersPackage.UserService;
import utils.Utils;

public class Executor {
    static BookDao bookDao = new BookDao();
    static UserDAO userDAO = new UserDAO();
    static UserService userService = new UserService();
    static BookService bookService = new BookService();
    static private User currentUser;

    public static void main(String[] args) {
        new Executor().init();
    }

    public void init() {
        while (true) {
            System.out.println(getCurrentUser());
            int enteredNumber = Utils.askEnterNumberInRange(
                    "Select action:\n" +
                            "1 - Registration\n" +
                            "2 - Sign in\n" +
                            "3 - Add Book\n" +
                            "4 - Get all books\n" +
                            "5 - Get book by value\n" +
                            "0 - Exit\n" +
                            "Enter number: ", 1, 5);
            switch (enteredNumber) {
                case 1 -> userDAO.create(userService.register());
                case 2 -> currentUser = userService.signIn(userDAO);
                case 3 -> userService.addBook(currentUser, bookDao);
                case 4 -> System.out.println(bookDao.getAll());
                case 5 -> selectBook();
                case 0 -> {
                    return;
                }
            }
        }
    }

    public void selectBook() {
        while (true) {
            int enteredNumber = Utils.askEnterNumberInRange(
                    "Select by what value to search book:\n" +
                            "1 - Author\n" +
                            "2 - Book name\n" +
                            "0 - Exit\n" +
                            "Enter number: ", 1, 5);
            switch (enteredNumber) {
                case 1 -> bookService.getBookByAuthor(bookDao).forEach(System.out::println);
                case 2 -> bookService.getBookByName(bookDao).forEach(System.out::println);
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static String getCurrentUser() {
        if (currentUser != null) {
            return "Current user: " + currentUser.getUsername();
        } else {
            return "Current user: Non authorized";
        }
    }
}
