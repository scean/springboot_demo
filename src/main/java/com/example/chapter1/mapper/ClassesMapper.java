package com.example.chapter1.mapper;

import com.example.chapter1.bean.mixmodel.Classes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassesMapper {
    Classes getClass(int classId);
}
