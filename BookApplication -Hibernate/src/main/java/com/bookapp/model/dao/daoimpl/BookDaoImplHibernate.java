package com.bookapp.model.dao.daoimpl;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dto.Book;
import com.bookapp.model.exception.BookNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Primary
public class BookDaoImplHibernate implements BookDao {

    private SessionFactory sessionFactory;


    @Autowired
    public BookDaoImplHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<Book> getAllBooks() {
        System.out.println("hello hibenatre get all books");
        return getSession().createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public Book addBook(Book book) {
        System.out.println("hello hibenatre add books");
        getSession().save(book);
        return book;
    }

    @Override
    public void deleteBook(int id) {
        System.out.println("hello hibenatre delete books");
        Book bookToDelete = getBookById(id);
        getSession().remove(bookToDelete);
    }

    @Override
    public void updateBook(int id, Book book) {
        System.out.println("hello hibenatre update all books");
        Book bookToUpdate = getBookById(id);
        bookToUpdate.setPrice(book.getPrice());
        getSession().merge(bookToUpdate);
    }

    @Override
    public Book getBookById(int id) {
        System.out.println("hello hibenatre get by id books");
        Book book = getSession().get(Book.class, id);
        if (book == null)
            throw new BookNotFoundException("book with" + id + "i not found");
        return book;
    }
}
