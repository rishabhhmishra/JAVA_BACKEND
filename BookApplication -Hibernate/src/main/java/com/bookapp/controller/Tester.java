package com.bookapp.controller;

import com.bookapp.model.dto.Book;
import com.bookapp.model.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("hib.config.xml");
        BookService bookService = ctx.getBean("service", BookService.class);
//        List<Book> books = bookService.getAllBooks();
//        System.out.println(books);
//        System.out.println("hello");

        bookService.addBook(new Book("EFGHF456","AppliedPhysics","Varun",9));
//        System.out.println("book is save in database");



//        System.out.println("hello");
//        System.out.println("--------------");
//        bookService.deleteBook(6);
//        System.out.println(books);
//        System.out.println("book is deleted by console");
//        bookService.addBook(new Book("Abcdef","Vlsi2","AmitShukla",1000));
//        List<Book> books1=bookService.getAllBooks();
//        System.out.println(books1);
//       Book book= bookService.getBookById(7);
//       Book book=new Book();
//        book.setPrice(1000);
//        bookService.updateBook(7,book);
//        System.out.println("book price is updated");



//        DriverManagerDataSource
      //  DataSourceTransactionManager

    }
}
