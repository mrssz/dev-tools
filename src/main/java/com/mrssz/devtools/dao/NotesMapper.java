package com.mrssz.devtools.dao;

import com.mrssz.devtools.entity.NotesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotesMapper {
    List<NotesEntity> queryDevtools();
}
