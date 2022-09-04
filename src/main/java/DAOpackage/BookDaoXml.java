package DAOpackage;

import XMLpackage.WriterReader;
import bookPackage.Book;
import catalogPackage.Catalog;

import java.util.ArrayList;
import java.util.List;

public class BookDaoXml implements DAO<Book> {
    private List<Book> books = new ArrayList<>();
    private WriterReader writerReader = new WriterReader();
    private Catalog catalog;
    public BookDaoXml() {
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
    public void create(Book book) {
        books.add(book);
        catalog.setBooks(books);
        writerReader.saveToXML(catalog);
    }

    @Override
    public void delete(Book o) {

    }

    @Override
    public void update(Book o, List<String> params) {

    }
}
