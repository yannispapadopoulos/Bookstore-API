package com.example.restprojpersado.controller;

import com.example.restprojpersado.entities.Author;
import com.example.restprojpersado.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookstore")
public class AuthorController {

   @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }


}
