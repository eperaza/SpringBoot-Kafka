package com.example.producer.controller;

import com.example.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path="/producer")
@Component
public class ProducerController {
    
    @Autowired
    private ProducerService producerService;

    @PostMapping(path="/send")
    public ResponseEntity<Object> sendMessageWithCallback(@RequestParam String message){
        producerService.sendMessageWithCallback(message);
        return new ResponseEntity<Object>("listo", HttpStatus.OK);
    }

    
}
