package com.tpspring.services;

import com.tpspring.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
}
