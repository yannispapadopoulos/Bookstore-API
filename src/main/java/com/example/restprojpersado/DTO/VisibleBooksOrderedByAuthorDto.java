package com.example.restprojpersado.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//public class VisibleBooksOrderedByAuthorDto {
//
//    private String title;
//    private String description;
//    private Integer ISBN;
//    private String authorFullName;
//
//    public VisibleBooksOrderedByAuthorDto(String title, String description ,Integer ISBN, String authorFullName){
//        this.title=title;
//        this.description=description;
//        this.ISBN=ISBN;
//        this.authorFullName=authorFullName;
//
//    }
//}
public interface VisibleBooksOrderedByAuthorDto {

    String getTitle();

    String getDescription();

    Integer getISBN();

    String getFullName();

    Integer getNumericvalue();

}
