package com.bookapp.model.dao.daoimpl;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dto.Book;
import com.bookapp.model.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
//@Primary
public class BookDaoImplUsingJdbc implements BookDao {
    private DataSource dataSource;

  @Autowired
    public BookDaoImplUsingJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();
        Book book = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();


            PreparedStatement pstmt = connection.prepareStatement("select * from amit_book");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

//                id,isbn,title,author,price
                book = new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5));
                books.add(book);
            }


        } catch (SQLException ex) {

            throw new BookNotFoundException("Book is not available in our databse");
        }

        System.out.println("Using JdbcDataSource: getAllBook");
        return books;

    }

    @Override
    public Book addBook(Book book) {
        Connection connection = null;

        System.out.println("book is added succesfully1");


        PreparedStatement pstmt = null;

        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            System.out.println("book is added succesfully1");
            pstmt = connection.prepareStatement("insert into amit_book(isbn,title,author,price) values(?,?,?,?)");
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setDouble(4, book.getPrice());
            pstmt.executeUpdate();
            connection.commit();
            System.out.println("book is added succesfully2");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException sqlException1) {
                sqlException1.printStackTrace();
            }
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        System.out.println("addBook: using jdbcDataSouce");


        return book;
    }


    @Override
    public void deleteBook(int id) {
        Connection connection=null;
        try{
            connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("delete from amit_book where id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(connection!=null)
                    connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("books is delted from jdbcDataSource");

    }

    @Override
    public void updateBook(int id, Book book) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
//            id,isbn,title,author,price
            PreparedStatement pstmt =
                    connection.prepareStatement(
                            "update amit_book set  price=? where  id=?");
            pstmt.setDouble(1, book.getPrice());
            pstmt.setInt(2, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from amit_book where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // id,isbn,title,author,price
                book = new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (book == null)
            throw new BookNotFoundException("Book is not find");

        return book;

    }
}
