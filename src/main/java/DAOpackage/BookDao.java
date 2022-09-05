package DAOpackage;

import XMLpackage.WriterReader;
import bookPackage.Book;
import bookPackage.PaperBook;
import catalogPackage.Catalog;

import java.util.ArrayList;
import java.util.List;

public class BookDao implements DAO<Book> {
    private final List<Book> books;
    private final WriterReader writerReader = new WriterReader();
    private final Catalog catalog;
    public BookDao() {
        catalog = writerReader.readCatalogFromXML();
        books = catalog.getBooks();
    }

    @Override
    public Book get(int id) {
        return null;
    }

    public List<Book> getAll() {
        return books;
    }

    @Override
    public void add(Book book) {
        books.add(book);
        refreshCatalog();
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
        refreshCatalog();
    }

    @Override
    public void update(Book o, List<String> params) {

    }

    public void refreshCatalog() {
        catalog.setBooks(books);
        writerReader.saveToXML(catalog);
    }
}
