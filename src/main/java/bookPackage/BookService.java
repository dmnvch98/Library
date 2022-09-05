package bookPackage;

import DAOpackage.BookDao;
import usersPackage.User;
import usersPackage.UserService;
import usersPackage.UserType;
import utils.Utils;

import java.util.List;
import java.util.stream.IntStream;

import static utils.Utils.*;

public class BookService {
    private List<String> askBookParams() {
        String author = askEnterString("%s%5s", "Enter author name (minimum 4 characters) : ", "");
        String name = askEnterString("%s%5s", "Enter book name (minimum 4 characters) : ", "");
        String description = askEnterString("%s%5s", "Enter book description (minimum 4 characters) : ", "");
        return List.of(name, author, description);
    }

    public PaperBook createPaperBook(User user, UserService userService) {
        if (userService.authentication(user)) {
            List<String> bookParams = askBookParams();
            return new PaperBook(bookParams.get(0), bookParams.get(1), bookParams.get(2));
        } else {
            System.out.println("WARNING: Not allowed. You are not admin");
            return null;
        }
    }

    public ElectronicBook createElectronicBook(User user, UserService userService) {
        if (userService.authentication(user)) {
            List<String> bookParams = askBookParams();
            return new ElectronicBook(bookParams.get(0), bookParams.get(1), bookParams.get(2));
        } else {
            System.out.println("WARNING: Not allowed. You are not admin");
            return null;
        }
    }

    public List<Book> getBookByName(BookDao BookDao) {
        String bookName = Utils.askEnterString("%s%5s", "Enter book name: ", "");
        return BookDao.getAll().stream().filter(b -> b.getName().equals(bookName)).toList();
    }

    public List<Book> getBookByAuthor(BookDao BookDao) {
        String bookAuthor = Utils.askEnterString("%s%5s", "Enter book author: ", "");
        return BookDao.getAll().stream().filter(b -> b.getAuthor().equals(bookAuthor)).toList();
    }

    public void addBook(BookDao bookDao, Book book) {
        if (book != null) {
            bookDao.add(book);
        }
    }

    public void removeBook(User user, BookDao bookDao, UserService userService) {
        if (userService.authentication(user)) {
            Book bookToRemove = selectBookToRemove(bookDao.getAll());
            bookDao.delete(bookToRemove);
        } else {
            System.out.println("WARNING: Not allowed. You are not admin");
        }
    }

    private Book selectBookToRemove(List<Book> books) {
        IntStream
                .range(0, books.size())
                .mapToObj(i -> String.format("%d - %s", i, books.get(i)))
                .forEach(System.out::println);
        int enteredNumber = Utils.askEnterNumberInRange("Select book to remove: ", 0, books.size());
        return books.get(enteredNumber);
    }

}
