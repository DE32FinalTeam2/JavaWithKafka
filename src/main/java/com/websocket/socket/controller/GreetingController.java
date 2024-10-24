package com.websocket.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.websocket.socket.greeting.Greeting;
import com.websocket.socket.message.HelloMessage;

@Controller
public class GreetingController {

    private static final String TOPIC = "abcdefg"; // Kafka 토픽 이름

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate; // KafkaTemplate 주입

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay

        // Kafka에 메시지를 전송
        String processedMessage = message.getName() + ":" + HtmlUtils.htmlEscape(message.getMessage());
        kafkaTemplate.send(TOPIC, processedMessage); // 메시지 전송

        return new Greeting(processedMessage); // 메시지 반환
    }
}
