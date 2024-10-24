package com.websocket.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;



@Component
public class KafkaMessageListener {


    private static final String TOPIC = "abcdefg"; // Kafka 토픽 이름   

    @KafkaListener(topics = TOPIC)
    @SendTo("/hello")
    public String listen(String message) {
        String message2= message;
        return message2;
    }
}