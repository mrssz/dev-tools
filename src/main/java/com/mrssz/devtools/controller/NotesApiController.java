package com.mrssz.devtools.controller;

import com.mrssz.devtools.dto.req.MixNoteQueryDto;
import com.mrssz.devtools.entity.NotesEntity;
import com.mrssz.devtools.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/noteApi")
public class NotesApiController {
    @Autowired
    NotesService notesService;

    @PostMapping("/mixQuery")
    public List<NotesEntity> mixQuery(@RequestBody MixNoteQueryDto queryDto) {
        System.out.println(queryDto);
        return notesService.mixQuery(queryDto);
    }
}
