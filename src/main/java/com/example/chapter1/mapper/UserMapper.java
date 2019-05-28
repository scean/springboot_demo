package com.example.chapter1.mapper;

import com.example.chapter1.bean.MybatisBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<MybatisBean> getAll();
    void insert(MybatisBean bean);
    void update(MybatisBean bean);
}
