package com.example.restprojpersado.REST;

import com.example.restprojpersado.entities.Book;
import com.example.restprojpersado.entities.Publisher;
import com.example.restprojpersado.exception.ApiRequestException;
import com.example.restprojpersado.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/addPublisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {


        if (publisher.getName() == null) {
            throw new ApiRequestException("publisher's firstname cannot be null");
        }

        return publisherService.savePublisher(publisher);
    }


}
