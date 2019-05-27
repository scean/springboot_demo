package com.example.chapter1.respository;

import com.example.chapter1.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserJDBCRepository {

    public void saveUser(User user,JdbcTemplate jdbcTemplate){
        int result = jdbcTemplate.update("insert into users(name,password,age) values(?,?,?)",user.getName(),user.getPassword(),user.getAge());
        System.out.println("save result == "+result);
    }
}
