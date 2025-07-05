package com.jackson.apache_kafka.testing.config.consumer;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MessageConsumer {

    @Value("${spring.kafka.topics.testing-event}")
    private String topicName;

    @Value("${spring.kafka.groups.testing-group}")
    private String groupId;

    @KafkaListener(topics = "#{__listener.topicName}", groupId = "#{__listener.groupId}")
    public void listen(String message){
        System.out.println("Received message" + message);
    }
}
