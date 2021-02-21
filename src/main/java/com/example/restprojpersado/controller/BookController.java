package com.example.restprojpersado.controller;

import com.example.restprojpersado.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.restprojpersado.services.BookService;
import java.util.List;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/addBooks")
    public List<Book> addBooks(@RequestBody List<Book> books){
        return bookService.saveBooks(books);
    }

    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/findBook/{isbn}")
    public Book findBook(@PathVariable Integer isbn){
        return bookService.getBook(isbn);
    }

    @PostMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @PostMapping("/deleteBook/{isbn}")
    public String deleteBook(@PathVariable Integer isbn){
        return bookService.deleteBook(isbn);
    }
}
