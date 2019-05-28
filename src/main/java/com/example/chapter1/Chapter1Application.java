package com.example.chapter1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.chapter1.mapper")
public class Chapter1Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

}
