package com.jackson.apache_kafka.testing.controller;

import com.jackson.apache_kafka.testing.config.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message){
        messageProducer.sendMessage("my-topic", message);
        return "Message sent : " + message;
    }

}
