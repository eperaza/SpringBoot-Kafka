package com.example.producer.service;

import org.springframework.stereotype.Component;

@Component
public interface IProducerService {

    public void sendMessageWithCallback(String message);

    
}
