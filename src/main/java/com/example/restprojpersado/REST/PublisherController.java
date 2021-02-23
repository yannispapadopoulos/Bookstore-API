package com.example.restprojpersado.REST;

import com.example.restprojpersado.entities.Publisher;
import com.example.restprojpersado.exception.ApiRequestException;
import com.example.restprojpersado.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/addPublisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        try {
            if (publisher.getName() == null) {
                throw new ApiRequestException("publisher's firstname cannot be null");
            }
            return publisherService.savePublisher(publisher);

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }

    }

    @GetMapping("/findPublisher/{id}")
    public Publisher findPublisher(@PathVariable Integer publisherId) {
        try {
            return publisherService.getPublisher(publisherId);

        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

}
