package com.mrssz.devtools.dao;

import com.mrssz.devtools.entity.NotesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotesMapper {
    List<NotesEntity> queryDevtools();

    void addNote(@Param("note") NotesEntity notesEntity);

    NotesEntity getNoteById(@Param("id") Long id);

    void deleteNoteById(Long id);
}
