package DAOpackage;//package DAOpackage;
//
//import bookPackage.Book;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//public class BookDAO implements DAO<Book> {
//    List<Book> books = new ArrayList<>();
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public Book get(int id) {
//        return books.get(3);
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return books;
//    }
//    @Override
//    public void initializeBooksListFromFile() {
//        Book[] booksFromFile;
//        File file = new File("books.json");
//        try {
//            booksFromFile = objectMapper.readValue(file, Book[].class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        books = new ArrayList<>(Arrays.asList(booksFromFile));
//    }
//
//    @Override
//    public void create(Book book) {
//        books.add(book);
//        saveBooksToFile();
//    }
//
//    @Override
//    public void update(Book book, List<String> params) {
//        book.setName(params.get(0));
//        book.setDescription(params.get(1));
//        book.setAuthor(params.get(2));
//        saveBooksToFile();
//    }
//
//    @Override
//    public void delete(Book book) {
//        books.remove(book);
//        saveBooksToFile();
//    }
//
//    private void saveBooksToFile() {
//        try {
//            objectMapper.writeValue(new File("books.json"), books);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
