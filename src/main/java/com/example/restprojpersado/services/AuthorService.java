package com.example.restprojpersado.services;

import com.example.restprojpersado.entities.Author;
import com.example.restprojpersado.DAO.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

}
