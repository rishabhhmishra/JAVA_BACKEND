package com.bookapp.controller;

import com.bookapp.model.dto.Book;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(ModelMap mv) {
        return "hello";
    }

    @GetMapping("showall")
    public String showAll(ModelMap mv) {
        mv.addAttribute("books", bookService.getAllBooks());
        return "show";
    }

    @GetMapping("delete")
    public String deleteBook(@RequestParam(name = "id") int id) {
        bookService.deleteBook(id);
        return "redirect:showall";
    }

    @GetMapping("addBook")
    public String addBookGet(ModelMap modelMap) {
        Book book = new Book();
        modelMap.addAttribute("book", book);
        return "addbook";

    }

    @PostMapping("addbook")
    public String addBookPost(@ModelAttribute(name = "book") Book book) {

        int id = book.getId();
        if (id == 0) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book.getId(), book);
        }
        return "redirect:showall";

    }

    @GetMapping("update")

    public String updateBookGet(ModelMap modelMap, @RequestParam(name = "id") int id) {
        modelMap.addAttribute("book", bookService.getBookById(id));

        return "updatebook";
    }

}

