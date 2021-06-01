package com.example.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.*;

@Component
@Service
public class Listener {

    //@Autowired
    //private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(groupId = "myGroup", topicPartitions = @TopicPartition(topic = "firstTopic",
    partitionOffsets = { 
        @PartitionOffset(partition = "0", initialOffset = "0"),
        @PartitionOffset(partition = "1", initialOffset = "0")
    }))
    //@SendTo("firstTopic")
    public void listenGroup(String message) {
		System.out.println("Received Message: " + message);
        //return "This is a reply sent after receiving message";
	}
    
}
