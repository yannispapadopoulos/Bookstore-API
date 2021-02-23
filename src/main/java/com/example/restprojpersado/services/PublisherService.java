package com.example.restprojpersado.services;

import com.example.restprojpersado.entities.Publisher;
import com.example.restprojpersado.DAO.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;


    public Publisher savePublisher(Publisher publisher) {

        return publisherRepository.save(publisher);
    }

    public Publisher getPublisher(Integer publisherId) {
        return publisherRepository.findById(publisherId).orElse(null);
    }
}
