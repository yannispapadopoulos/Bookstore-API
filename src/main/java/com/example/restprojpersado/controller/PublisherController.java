package com.example.restprojpersado.controller;

import com.example.restprojpersado.entities.Publisher;
import com.example.restprojpersado.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookstore")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/addAuthor")
    public Publisher addAuthor(@RequestBody Publisher publisher) {
        return publisherService.savePublisher(publisher);
    }


}
