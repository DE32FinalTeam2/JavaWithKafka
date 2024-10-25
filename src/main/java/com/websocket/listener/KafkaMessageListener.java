package com.websocket.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    private static final String TOPIC = "abcdefg"; // Kafka 토픽 이름   

    @KafkaListener(topics = TOPIC)
    @SendTo("/hello")
    public String listen(ConsumerRecord<String, String> record) {
        String message = record.value();
        long offset = record.offset(); // 오프셋을 가져옴

        // 필요한 추가 작업을 여기에 수행
        return message; // 여기에서 메시지를 반환 (수정 가능)
    }
}
