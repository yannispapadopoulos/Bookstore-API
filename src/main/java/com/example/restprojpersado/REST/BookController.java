package com.example.restprojpersado.REST;

import com.example.restprojpersado.DTO.BookDetails;
import com.example.restprojpersado.DTO.BookInfoDto;
import com.example.restprojpersado.DTO.VisibleBooksOrderedByAuthorDto;
import com.example.restprojpersado.entities.Author;
import com.example.restprojpersado.entities.Book;
import com.example.restprojpersado.entities.Publisher;
import com.example.restprojpersado.exception.ApiRequestException;
import com.example.restprojpersado.services.AuthorService;
import com.example.restprojpersado.services.PublisherService;
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
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/findOrderPublishedBooksByAuthor")
    public List<VisibleBooksOrderedByAuthorDto> findOrderPublishedBooksByAuthor() {
        try {
            List<VisibleBooksOrderedByAuthorDto> listVisibleBooksOrderedByAuthorDto = bookService.getOrderPublishedBooksByAuthor();
            if (listVisibleBooksOrderedByAuthorDto == null) {
                throw new ApiRequestException("visible books with publisher not found");
            }
            return bookService.getOrderPublishedBooksByAuthor();

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    @GetMapping("/singleBookInfo")
    public ResponseEntity<BookInfoDto> singleBookInfo() {

        try {
            BookInfoDto existBook = null;
            existBook = bookService.displaySingleBookInfo();
            if (existBook == null) {
                throw new ApiRequestException("book record not found. Database has no records");
            }
            return new ResponseEntity<BookInfoDto>(existBook, HttpStatus.OK);

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }


    }

    @PostMapping("/addBookStrict")
    public ResponseEntity<Book> addBookStrict(@RequestBody BookDetails bookDetails) {

        try {
            Book bookRes;
            if (bookDetails == null) {
                throw new ApiRequestException("json Object is null");
            }
            if (bookDetails.getTitle() == null) {
                throw new ApiRequestException("title cannot be null");
            }

            if (bookDetails.getAuthorId() == null) {
                throw new ApiRequestException("author Id cannot be null");
            }

            Author author = authorService.getAuthor(bookDetails.getAuthorId());
            if (author == null) {
                throw new ApiRequestException("author does not exist.Insert author first");
            }
            if (bookDetails.getPublisherId() == null) {
                throw new ApiRequestException("publisher Id cannot be null");
            }
            Publisher publisher = publisherService.getPublisher(bookDetails.getPublisherId());
            if (publisher == null) {
                throw new ApiRequestException("publisher does not exist.Insert publisher first");
            }

            bookRes = bookService.saveBookDetails(bookDetails, publisher, author);
            return new ResponseEntity<Book>(bookRes, HttpStatus.OK);

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }

    }


    @PostMapping("/addBookOptional")
    public ResponseEntity<Book> addBookOptional(@RequestBody Book book) {

        try {
            Book bookRes;
            if (book == null) {
                throw new ApiRequestException("json Object is null");
            }

            if (book.getIsbn() == null) {
                throw new ApiRequestException("isbn cannot be null");
            }
            if (book.getTitle() == null) {
                throw new ApiRequestException("title cannot be null");
            }

            bookRes = bookService.saveBook(book);
            return new ResponseEntity<Book>(bookRes, HttpStatus.OK);

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }


    }


    @PostMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {

        try {
            Book bookRes;
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
            bookRes = bookService.updateBook(book);
            return new ResponseEntity<Book>(bookRes, HttpStatus.OK);

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }
    }


    @PostMapping("/deleteBook/{isbn}")
    public String deleteBook(@PathVariable Integer isbn) {

        try {
            if (isbn == null) {
                throw new ApiRequestException("variable isbn missing from path");
            }

            Book existBook = bookService.getBook(isbn);
            if (existBook == null) {
                throw new ApiRequestException("book with isbn :" + isbn + " does not exist");

            }
            return bookService.deleteBook(isbn);

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }

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
