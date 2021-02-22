package com.example.restprojpersado.DTO;

import com.example.restprojpersado.entities.Author;
import com.example.restprojpersado.entities.Publisher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
