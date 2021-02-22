package com.example.restprojpersado.REST;

import com.example.restprojpersado.DTO.BookInfoDto;
import com.example.restprojpersado.DTO.VisibleBooksOrderedByAuthorDto;
import com.example.restprojpersado.entities.Book;
import com.example.restprojpersado.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restprojpersado.services.BookService;

import java.util.List;
import java.util.NoSuchElementException;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findOrderPublishedBooksByAuthor")
    public List<VisibleBooksOrderedByAuthorDto> findOrderPublishedBooksByAuthor() {
        List<VisibleBooksOrderedByAuthorDto> listVisibleBooksOrderedByAuthorDto = bookService.getOrderPublishedBooksByAuthor();
        if (listVisibleBooksOrderedByAuthorDto == null) {
            throw new ApiRequestException("visible books with publisher not found");
        }
        return bookService.getOrderPublishedBooksByAuthor();
    }

    @GetMapping("/singleBookInfo")
    public ResponseEntity<BookInfoDto> singleBookInfo() {
        BookInfoDto existBook = bookService.displaySingleBookInfo();
        if (existBook == null) {
            throw new ApiRequestException("book record not found. Database has no records");
        }
        return new ResponseEntity<BookInfoDto>(existBook, HttpStatus.OK);
    }

    @PostMapping("/addBook")

    public ResponseEntity<Book> addBook(@RequestBody Book book) {


        if (book.getTitle() == null) {
            throw new ApiRequestException("title cannot be null");
        }

        bookService.saveBook(book);

        return new ResponseEntity<Book>(book, HttpStatus.OK);

    }

    @PostMapping("/addBookWithAuthPubl")
    public ResponseEntity<Book> addBookWithAuthPubl(@RequestBody Book book) {


        if (book.getTitle() == null) {
            throw new ApiRequestException("title cannot be null");
        }

        if (book.getAuthor() == null) {
            throw new ApiRequestException("author cannot be null");
        }
        if (book.getPublisher() == null) {
            throw new ApiRequestException("publisher cannot be null");
        }

        bookService.saveBook(book);

        return new ResponseEntity<Book>(book, HttpStatus.OK);

    }


    @PostMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {


        if (book == null) {
            throw new ApiRequestException("json Object is null");
        }

        if (book.getIsbn() == null) {
            throw new ApiRequestException("isbn is null");

        }
        Book existBook = bookService.getBook(book.getIsbn());

        if (existBook == null) {
            throw new ApiRequestException("book with isbn :" + book.getIsbn() + " does not exist");
        }
        bookService.updateBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);

    }


    @PostMapping("/deleteBook/{isbn}")
    public String deleteBook(@PathVariable Integer isbn) {
        if (isbn == null) {
            throw new ApiRequestException("variable isbn missing from path");
        }

        Book existBook = bookService.getBook(isbn);
        if (existBook == null) {
            throw new ApiRequestException("book with isbn :" + isbn + " does not exist");

        }
        return bookService.deleteBook(isbn);
    }

/////////////////////////////////////////////extra functions in case of need//////////////////////////////////////////////////////////

    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/findBook/{isbn}")
    public Book findBook(@PathVariable Integer isbn) {
        return bookService.getBook(isbn);
    }


    @PostMapping("/addBooks")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return bookService.saveBooks(books);
    }

}
