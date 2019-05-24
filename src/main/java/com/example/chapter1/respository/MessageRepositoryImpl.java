package com.example.chapter1.respository;

import com.example.chapter1.bean.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageRepositoryImpl implements MessageRepository {

    private AtomicLong counter = new AtomicLong();
    private final ConcurrentHashMap<Long,Message> messages = new ConcurrentHashMap<>();

    @Override
    public Message save(Message message) {
        if(message.getId() == null){
            message.setId(counter.incrementAndGet());
        }
        messages.put(message.getId(),message);
        return message;
    }

    @Override
    public void deleteMessage(Long id) {
        messages.remove(id);
    }

    @Override
    public Message update(Message message) {
        messages.put(message.getId(),message);
        return message;
    }

    @Override
    public List<Message> findAll() {
        List<Message> list = new ArrayList<>(messages.values());
        return list;
    }

    @Override
    public Message findMessage(Long id) {
        return messages.get(id);
    }

    @Override
    public void saveMessageList(List<Message> list) {
        System.out.println(list.get(list.size()-1).getSummary());
    }
}
