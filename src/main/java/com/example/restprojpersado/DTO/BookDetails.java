package com.example.restprojpersado.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetails {

    private Integer isbn;

    private String title;

    private String descr;

    private Integer authorId;

    private Integer publisherId;

    private Integer visible;

    private Date date_creation;


}
