package com.websocket.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class KafkaMessageListener {

    private static final String LOG_FILE_PATH = "/home/tommy/code/4rd/chating/src/main/java/shop/samdul/chating/kafka_messages.log"; // 로그 파일 경로
    private static final String TOPIC = "abcdefg"; // Kafka 토픽 이름

    @KafkaListener(topics = TOPIC, groupId = "chat-group") // 그룹 ID 설정
    public void listen(String message, String user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            // 메시지를 로그 파일에 저장
            writer.write(user + ": " + message);
            writer.newLine(); // 새로운 줄 추가
            writer.flush();
            
            // 메시지 출력
            System.out.println(user + ": " + message);
        } catch (IOException e) {
            System.err.println("로그 파일을 생성하거나 쓰는 데 문제가 발생했습니다.");
            e.printStackTrace();
        }
    }
}

