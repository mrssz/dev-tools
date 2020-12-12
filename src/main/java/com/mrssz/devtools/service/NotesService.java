package com.mrssz.devtools.service;

import com.mrssz.devtools.dao.NotesMapper;
import com.mrssz.devtools.entity.NotesEntity;
import org.apache.ibatis.annotations.Param;
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

    public NotesEntity getNoteById(Long id) {
        return notesMapper.getNoteById(id);
    }

    public void deleteNoteById(Long id) {
        notesMapper.deleteNoteById(id);
    }
}
