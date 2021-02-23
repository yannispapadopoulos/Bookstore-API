package com.example.restprojpersado.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfoDto {

    private String title;

    private String description;

    private Integer ISBN;

    private Date bookDate;

    private String authorFullname;

    private String authorEmail;

    private Date authorBirthDate;

    private String publisherName;

    private String publisherAddress;

}
