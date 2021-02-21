package com.example.restprojpersado.repositories;

import com.example.restprojpersado.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Integer>{
    //List<Book> findAllByOOrderByAuthor_id;
}
