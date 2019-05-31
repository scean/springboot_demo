package com.example.chapter1.web;

import com.example.chapter1.exception.MyException;
import com.example.chapter1.respository.UserJDBCRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() throws Exception{
//        return "hello===1000";
        throw  new MyException("xxxxxxxxxxxxxx");
    }

    @GetMapping("/get/hello")
    public String sayGetHello(String name){
        return "hello,"+name;
    }

    @PostMapping("/post/hello")
    public String postGetHello(String name){
        return "hello,"+name;
    }

}
