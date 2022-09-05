package XMLpackage;

import catalogPackage.Catalog;
import usersPackage.UserList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Для чтения и записи файла используется библиотека JAXB. Используемый формат данных - xml.
 * Для работы класса необходимо имортировать в pom.xml javax.xml.bind и com.sun.xml.bind
 * **/
public class WriterReader {
    private static final File booksFile = new File("books.xml");
    private static final File usersFile = new File("users.xml");

    /**
     * @param catalog вспомогательный класс для учета книг
     * **/
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
    /**
     * @param userList вспомогательный класс для учета пользователей
     * **/
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
