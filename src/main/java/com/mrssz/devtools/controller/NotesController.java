package com.mrssz.devtools.controller;

import com.mrssz.devtools.constant.CommonConstant;
import com.mrssz.devtools.dto.req.MixNoteQueryDto;
import com.mrssz.devtools.entity.NotesEntity;
import com.mrssz.devtools.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/note")
@Controller
public class NotesController {
    @Autowired
    NotesService notesService;

    @GetMapping("/index")
    public String noteIndex(Model model) {
        List<NotesEntity> notes = notesService.getAll();
        model.addAttribute("notes", notes);
        return "notes/index";
    }

    @PostMapping("/add")
    public String noteIndexPost(String title, String author, String content) {
        NotesEntity notesEntity = new NotesEntity();
        notesEntity.setTitle(title);
        notesEntity.setAuthor(author);
        notesEntity.setContent(content);
        notesService.addNote(notesEntity);
        return "redirect:/note/index";
    }

    @GetMapping("/query")
    public String getNote(Model model, Long id) {
        NotesEntity note = notesService.getNoteById(id);
        model.addAttribute("note", note);
        return "notes/details";
    }

    @GetMapping("/delete")
    public String deleteNote(Long id) {
        notesService.deleteNoteById(id);
        return "redirect:/note/index";
    }

    @PostMapping("/mixQuery")
    public List<NotesEntity> mixQuery(MixNoteQueryDto queryDto) {
        return notesService.mixQuery(queryDto);
    }

}
