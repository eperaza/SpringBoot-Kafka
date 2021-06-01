package com.example.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Service
public class ProducerService implements IProducerService {
    static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);
        
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageWithCallback(String message) {
        ListenableFuture<SendResult<String, String>> future = 
          kafkaTemplate.send("firstTopic","1", message);
      
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
          @Override
          public void onSuccess(SendResult<String, String> result) {
            LOG.info("Message [{}] delivered with offset {}",
              message,
              result.getRecordMetadata().offset());
          }
      
          @Override
          public void onFailure(Throwable ex) {
            LOG.warn("Unable to deliver message [{}]. {}", 
              message,
              ex.getMessage());
          }
        });
      }
      
    
    
}
