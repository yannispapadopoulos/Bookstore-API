package com.example.restprojpersado.services;

import com.example.restprojpersado.DTO.BookInfoDto;
import com.example.restprojpersado.DTO.VisibleBooksOrderedByAuthorDto;
import com.example.restprojpersado.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restprojpersado.DAO.BookRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<VisibleBooksOrderedByAuthorDto> getOrderPublishedBooksByAuthor() {
        return bookRepository.orderPublishedBooksByAuthorQry();

    }

    public BookInfoDto displaySingleBookInfo() {
        Book book = bookRepository.findAll().stream().findFirst().orElseThrow(null);
        BookInfoDto bookInfoDto = new BookInfoDto();
//        String datetest=String.valueOf(book.getAuthor().getBirth_date()) ;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy", Locale.ENGLISH);
//        LocalDate dateTime = LocalDate.parse(datetest, formatter);

        bookInfoDto.setISBN(book.getIsbn());
        bookInfoDto.setTitle(book.getTitle());
        bookInfoDto.setDescription(book.getDescr());
        bookInfoDto.setBookDate(book.getDate_creation());
        bookInfoDto.setAuthorEmail(book.getAuthor().getEmail());
        bookInfoDto.setAuthorBirtDate(book.getAuthor().getBirth_date());
        bookInfoDto.setAuthorFullname(book.getAuthor().getFirstname() + " " + book.getAuthor().getLastname());
        bookInfoDto.setPublisherName(book.getPublisher().getName());
        bookInfoDto.setPublisherAddress(book.getPublisher().getAddress());


        return bookInfoDto;

    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public String deleteBook(Integer isbn) {
        bookRepository.deleteById(isbn);
        return "Book " + isbn + " succesfully removed";

    }

    public Book updateBook(Book book) {
        Book existinBook = bookRepository.findById(book.getIsbn()).orElse(null);
        existinBook.setIsbn(book.getIsbn());
        existinBook.setAuthor(book.getAuthor());
        ;
        existinBook.setDescr(book.getDescr());
        existinBook.setDate_creation(book.getDate_creation());
        existinBook.setPublisher(book.getPublisher());
        existinBook.setTitle(book.getTitle());
        existinBook.setVisible(book.getVisible());
        return bookRepository.save(existinBook);
    }

    public Book getBook(Integer isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    public List<Book> saveBooks(List<Book> books) {
        return bookRepository.saveAll(books);
    }


}
