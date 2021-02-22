package com.example.restprojpersado.DAO;


import com.example.restprojpersado.DTO.BookInfoDto;
import com.example.restprojpersado.DTO.VisibleBooksOrderedByAuthorDto;
import com.example.restprojpersado.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    // @Query("SELECT b FROM new VisibleBooksOrderedByAuthorDto b WHERE b.publisher is not null AND b.visible=1 ORDER BY b.author.lastname asc ")
    //List<VisibleBooksOrderedByAuthorDto> orderPublishedBooksByAuthorQry();


    @Query(value = "select title as title ,CASE WHEN LENGTH(description)>100 THEN CONCAT(SUBSTRING(description,1,100),'...') ELSE description END" +
            " as description ,ISBN as ISBN , fullname as fullname, numericvalue as numericvalue " +
            " from (select CONCAT(a.firstname,a.lastname) as fullname, a.lastname as lastname,b.isbn as ISBN, b.title as title," +
            " b.descr as description ,row_number() over (partition by a.lastname order by a.lastname ) as numericvalue from  book b ,author a  where " +
            "b.author_id=a.id and a.id is not null and b.visible=1) b order by b.lastname, b.numericvalue desc", nativeQuery = true)
    List<VisibleBooksOrderedByAuthorDto> orderPublishedBooksByAuthorQry();


}
