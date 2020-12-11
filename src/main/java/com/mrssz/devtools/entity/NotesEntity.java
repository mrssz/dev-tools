package com.mrssz.devtools.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesEntity {
    private Long id;
    private String title;
    private String author;
    private String content;
    private Date submission_date;
}
