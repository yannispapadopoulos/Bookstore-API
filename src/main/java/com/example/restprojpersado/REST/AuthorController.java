package com.example.restprojpersado.REST;

import com.example.restprojpersado.entities.Author;
import com.example.restprojpersado.entities.Publisher;
import com.example.restprojpersado.exception.ApiRequestException;
import com.example.restprojpersado.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        try {
            if (author.getFirstname() == null) {
                throw new ApiRequestException("author's firstname cannot be null");
            }
            if (author.getLastname() == null) {
                throw new ApiRequestException("author's lastname cannot be null");
            }
            return authorService.saveAuthor(author);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }


    }


    @GetMapping("/findPAuthor/{id}")
    public Author findPAuthor(@PathVariable Integer authorId) {
        try {
            return authorService.getAuthor(authorId);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }
    }


}
