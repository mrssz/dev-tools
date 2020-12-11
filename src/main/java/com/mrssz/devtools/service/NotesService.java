package com.mrssz.devtools.service;

import com.mrssz.devtools.dao.NotesMapper;
import com.mrssz.devtools.entity.NotesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesMapper notesMapper;

    public List<NotesEntity> getAll(){
        return notesMapper.queryDevtools();
    }

    public void addNote(NotesEntity notesEntity) {
        notesMapper.addNote(notesEntity);
    }
}
