package com.example.restprojpersado.services;

import com.example.restprojpersado.entities.Author;
import com.example.restprojpersado.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookService bookService;



    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

}
