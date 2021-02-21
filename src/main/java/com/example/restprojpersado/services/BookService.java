package com.example.restprojpersado.services;

import com.example.restprojpersado.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restprojpersado.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
       return bookRepository.save(book);
    }

    public List<Book> saveBooks(List<Book> books){
        return bookRepository.saveAll(books);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(Integer isbn){
        return bookRepository.findById(isbn).orElse(null);
    }



    public String deleteBook(Integer isbn){
        bookRepository.deleteById(isbn);
        return "Book "+isbn+" succesfully removed";

    }

    public Book updateBook(Book book){
        Book existinBook=bookRepository.findById(book.getIsbn()).orElse(null);
        existinBook.setIsbn(book.getIsbn());
        existinBook.setAuthor(book.getAuthor());;
        existinBook.setDescr(book.getDescr());
        existinBook.setDate_creation(book.getDate_creation());
        existinBook.setPublisher(book.getPublisher());
        existinBook.setTitle(book.getTitle());
        existinBook.setVisible(book.getVisible());
        return bookRepository.save(existinBook);
    }


}
