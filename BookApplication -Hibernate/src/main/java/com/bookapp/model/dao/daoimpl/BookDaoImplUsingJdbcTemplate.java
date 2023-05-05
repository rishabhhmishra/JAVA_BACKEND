package com.bookapp.model.dao.daoimpl;

import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dto.Book;
import com.bookapp.model.dto.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

@Repository
//@Primary
public class BookDaoImplUsingJdbcTemplate implements BookDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImplUsingJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select * from amit_book", new BookRowMapper());
    }

    @Override
    public Book addBook(Book book) {
//        id,isbn,title,author,price
        jdbcTemplate.update("insert into amit_book(isbn,title,author,price) values(?,?,?,?)",
                new Object[]{book.getIsbn(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice()});
        return book;

    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update("delete from amit_book where id=?,id");
    }

    @Override
    public void updateBook(int id, Book book) {
        jdbcTemplate.update("update amit_book set price=? where id=?", new Object[]{book.getPrice(), id});


    }

    @Override
    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject("select * from amit_book where id=?", new BookRowMapper(), id);
    }
}
