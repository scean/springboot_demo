package com.example.chapter1.respository;

import com.example.chapter1.bean.Message;

import java.util.List;

public interface MessageRepository {
    Message save(Message message);

    void saveMessageList(List<Message> list);
    void deleteMessage(Long id);
    List<Message> findAll();
    Message findMessage(Long id);
    Message update(Message message);

}
