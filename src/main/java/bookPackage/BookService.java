package bookPackage;

import DAOpackage.BookDaoXml;

import java.util.List;

import static utils.Utils.*;

public class BookService {
    public Book createBook() {
        String author = askEnterString("%s%5s", "Enter book name (minimum 4 characters) : ", "");
        String name = askEnterString("%s%5s", "Enter author name (minimum 4 characters) : ", "");
        String description = askEnterString("%s%5s", "Enter book description (minimum 4 characters) : ", "");

        return new Book(name, author, description);
    }

    public List<Book> getBookByName(BookDaoXml bookDaoXml, String bookName) {
        return bookDaoXml.getAll().stream().filter(b -> b.getName().equals(bookName)).toList();
    }

}
