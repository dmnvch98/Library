package bookPackage;

import DAOpackage.BookDao;
import utils.Utils;

import java.util.List;

import static utils.Utils.*;

public class BookService {
    public Book createBook() {
        String author = askEnterString("%s%5s", "Enter author name (minimum 4 characters) : ", "");
        String name = askEnterString("%s%5s", "Enter book name (minimum 4 characters) : ", "");
        String description = askEnterString("%s%5s", "Enter book description (minimum 4 characters) : ", "");
        return new Book(name, author, description);
    }

    public PaperBook cratePaperBook() {
        List<String> params = bookParams();
        return new PaperBook(params.get(0), params.get(1), params.get(2));
    }

    private List<String> bookParams() {
        String author = askEnterString("%s%5s", "Enter author name (minimum 4 characters) : ", "");
        String name = askEnterString("%s%5s", "Enter book name (minimum 4 characters) : ", "");
        String description = askEnterString("%s%5s", "Enter book description (minimum 4 characters) : ", "");
        return List.of(name, author, description);
    }

    public List<Book> getBookByName(BookDao BookDao) {
        String bookName = Utils.askEnterString("%s%5s","Enter book name: ", "");
        return BookDao.getAll().stream().filter(b -> b.getName().equals(bookName)).toList();
    }

    public List<Book> getBookByAuthor(BookDao BookDao) {
        String bookAuthor = Utils.askEnterString("%s%5s","Enter book author: ", "");
        return BookDao.getAll().stream().filter(b -> b.getAuthor().equals(bookAuthor)).toList();
    }

}
