package com.bookapp.model.service.impl;

import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dto.Book;
import com.bookapp.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value="service")
@Transactional
public class BookServiceImpl implements BookService {

    private BookDao bookDao;


    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();

    }

    @Override
    public Book addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {

        bookDao.deleteBook(id);

    }

    @Override
    public void updateBook(int id, Book book) {
        bookDao.updateBook(id,book);

    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}
