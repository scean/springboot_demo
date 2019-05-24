package com.example.chapter1.web;

import com.example.chapter1.exception.MyException;
import com.example.chapter1.respository.UserJDBCRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() throws Exception{
//        return "hello===1000";
        throw  new MyException("xxxxxxxxxxxxxx");
    }

    @GetMapping("/get/hello")
    public String sayGetHello(@RequestParam String name){
        return "hello,"+name;
    }



}
