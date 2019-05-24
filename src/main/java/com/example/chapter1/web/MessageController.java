package com.example.chapter1.web;

import com.example.chapter1.bean.Message;
import com.example.chapter1.exception.ApiResponse;
import com.example.chapter1.respository.MessageRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "消息", description = "消息操作 API", position = 100, protocols = "http ")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageRepository messageRepositoryImpl;

    @PostMapping("create")
    public Message create(Message message){
        System.out.println("messageRepositoryImpl="+messageRepositoryImpl);
        return messageRepositoryImpl.save(message);
    }

    @GetMapping("get/{id}")
    public ApiResponse<Message> findMessage(@PathVariable("id") Long id){
        Message message =  messageRepositoryImpl.findMessage(id);
        ApiResponse<Message> ar = new ApiResponse<>();
        ar.setMessage("success");
        ar.setCode(ApiResponse.OK);
        ar.setData(message);
        ar.setUrl("/get");
        return ar;
    }

    @ApiOperation(
            value = "消息列列表",
            notes = "完整的消息内容列列表",
            produces="application/json, application/xml",
            consumes="application/json, application/xml",
            response = List.class)
    @GetMapping("getAll")
    public List<Message> getAllMessage(){
        return messageRepositoryImpl.findAll();
    }

    @PostMapping(value = "saveAll")
    public String testUser(@RequestBody List<Message> user){
        System.out.print("user count = "+user.size());
        return "success";
    }
}
