package XMLpackage;

import catalogPackage.Catalog;
import usersPackage.UserList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class WriterReader {
    private static final File booksFile = new File("books.xml");
    private static final File usersFile = new File("users.xml");
//    public static void main(String[] args) {
//        Book book = new Book("name", "author", "description");
//        Book book2 = new Book("name2", "author2", "description2");
//        Book book3 = new Book("name3", "author3", "description3");
//        Book book4 = new Book("name4", "author4", "description4");
//        List<Book> books = new ArrayList<>();
//        books.add(book);
//        books.add(book2);
//        books.add(book3);
//        books.add(book4);
//        Catalog catalog = new Catalog(books);
//        new WriterReader().readFromXML();
//    }
    public void saveToXML(Catalog catalog) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(catalog, booksFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveToXML(UserList userList) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(userList, usersFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Catalog readCatalogFromXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Catalog) unmarshaller.unmarshal(booksFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public UserList readUsersFromXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (UserList) unmarshaller.unmarshal(usersFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
