import DAOpackage.BookDao;
import DAOpackage.UserDAO;
import bookPackage.BookService;
import usersPackage.User;
import usersPackage.UserService;
import utils.Utils;

/**
 * Входная точка в программу
 * **/
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
                            "6 - Remove book\n" +
                            "0 - Exit\n" +
                            "Enter number: ", 1, 5);
            switch (enteredNumber) {
                case 1 -> userDAO.add(userService.register(userDAO));
                case 2 -> currentUser = userService.signIn(userDAO);
                case 3 -> selectTypeOfBook();
                case 4 -> bookDao.getAll().forEach(System.out::println);
                case 5 -> selectBook();
                case 6 -> bookService.removeBook(currentUser, bookDao, userService);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void selectBook() {
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

    private void selectTypeOfBook() {
        while (true) {
            int enteredNumber = Utils.askEnterNumberInRange(
                    "Select book type:\n" +
                            "1 - Paper\n" +
                            "2 - Electronic\n" +
                            "0 - Exit\n" +
                            "Enter number: ", 0, 1
            );
            switch (enteredNumber) {
                case 1 -> bookService.addBook(bookDao, bookService.createPaperBook(currentUser, userService));
                case 2 -> bookService.addBook(bookDao, bookService.createElectronicBook(currentUser, userService));
                case 0 -> {return;}
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
