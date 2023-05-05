package com.bookapp.model.dao.daoimpl;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dto.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
//@Primary
public class BookDaoImplUsingMap implements BookDao {

    public static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
    private static int counter = 0;

    static {
        booksMap.put(++counter, new Book(counter, "Java123", "Head First Java", "Kathy", 600));
        booksMap.put(++counter, new Book(counter, "Servlet456", "Servlet Jsp", "Kathy", 700));
    }


    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(booksMap.values());
    }

    @Override
    public Book addBook(Book book) {
        book.setId(++counter);
        booksMap.put(counter, book);
        return booksMap.get(counter);
    }

    @Override
    public void deleteBook(int id) {
        booksMap.remove(id);

    }

    @Override
    public void updateBook(int id, Book book) {
        booksMap.put(id, book);

    }

    @Override
    public Book getBookById(int id) {
        return booksMap.get(id);
    }
}
