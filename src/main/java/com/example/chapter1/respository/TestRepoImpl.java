package com.example.chapter1.respository;

import com.example.chapter1.bean.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestRepoImpl implements MessageRepository {
    @Override
    public Message findMessage(Long id) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public Message save(Message message) {
        return null;
    }

    @Override
    public Message update(Message message) {
        return null;
    }

    @Override
    public void saveMessageList(List<Message> list) {

    }

    @Override
    public void deleteMessage(Long id) {

    }
}
