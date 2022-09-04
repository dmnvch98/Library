package XMLpackage;

import bookPackage.Book;
import catalogPackage.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WriterReader {
    private static final File file = new File("books.xml");
    public static void main(String[] args) {
        Book book = new Book("name", "author", "description");
        Book book2 = new Book("name2", "author2", "description2");
        Book book3 = new Book("name3", "author3", "description3");
        Book book4 = new Book("name4", "author4", "description4");
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Catalog catalog = new Catalog(books);
        new WriterReader().readFromXML();
    }
    public void saveToXML(Catalog catalog) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(catalog, file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Catalog readFromXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Catalog catalog = (Catalog) unmarshaller.unmarshal(file);
            return catalog;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
