import DAOpackage.BookDaoXml;
import DAOpackage.DAO;
import bookPackage.Book;

public class Executor {
    static DAO<Book> bookDao;
    public static void main(String[] args) {
        bookDao = new BookDaoXml();
        System.out.println(bookDao.getAll());
//        bookDao.create(new Book("Eugen is the best programmer", "It's a joke", "Hahaha"));
//        System.out.println(bookDao.getAll());
    }
}
