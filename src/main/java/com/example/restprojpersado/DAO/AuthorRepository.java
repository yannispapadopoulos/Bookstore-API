package com.example.restprojpersado.DAO;

import com.example.restprojpersado.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
