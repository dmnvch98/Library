package catalogPackage;

import bookPackage.Book;
import bookPackage.ElectronicBook;
import bookPackage.PaperBook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "catalog")
public class Catalog {
    private List<Book> books = new ArrayList<>();
    private List<PaperBook> paperBooks = new ArrayList<>();
    private List<ElectronicBook> electronicBook = new ArrayList<>();

    public Catalog(List<Book> catalog) {
        this.books = catalog;
    }

//    public Catalog(List<Book> books, List<PaperBook> paperBooks) {
//        this.books = books;
//        this.paperBooks = paperBooks;
//    }

    public Catalog() {
    }
    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<PaperBook> getPaperBooks() {
        return paperBooks;
    }

    public void setPaperBooks(List<PaperBook> paperBooks) {
        this.paperBooks = paperBooks;
    }

    public List<ElectronicBook> getElectronicBook() {
        return electronicBook;
    }

    public void setElectronicBook(List<ElectronicBook> electronicBook) {
        this.electronicBook = electronicBook;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "books=" + books +
                '}';
    }
}
