package com.example.restprojpersado.services;

import com.example.restprojpersado.entities.Publisher;
import com.example.restprojpersado.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher savePublisher(Publisher publisher){

        return publisherRepository.save(publisher);
    }

}
