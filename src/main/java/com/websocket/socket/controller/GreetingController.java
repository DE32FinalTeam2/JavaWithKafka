package com.websocket.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

import com.websocket.socket.entity.Team2Entity;
import com.websocket.socket.greeting.Greeting;
import com.websocket.socket.message.HelloMessage;
import com.websocket.socket.service.Team2Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class GreetingController {

    private static final String TOPIC = "abcdefg"; // Kafka 토픽 이름
    private static final String LOG_DIR_PATH = "/home/ubuntu/log";
    private static final String LOG_FILE_PATH = LOG_DIR_PATH + "/team2chat_messages.log"; // 로그 파일 경로

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate; // KafkaTemplate 주입

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message, String message2) throws Exception {
        Thread.sleep(200); // simulated delay

        // 현재 시간 포맷 지정
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);

        // Kafka에 메시지를 전송할 메시지 포맷
        String processedMessage = "[" + formattedTime + "] " + message.getName() + " : " + HtmlUtils.htmlEscape(message.getMessage());
        String proMessage = formattedTime + " , " + message.getName() + " , " + HtmlUtils.htmlEscape(message.getMessage());

        kafkaTemplate.send(TOPIC, proMessage); // Kafka로 메시지 전송

        // 로그 파일에 메시지 기록
        writeToLogFile(proMessage);

        return new Greeting(processedMessage); // 메시지 반환
    }

    // 로그 파일에 기록하는 메서드
    private void writeToLogFile(String message) {
        try {
            // 디렉터리 생성 (존재하지 않는 경우에만)
            Path logDir = Paths.get(LOG_DIR_PATH);
            if (!Files.exists(logDir)) {
                Files.createDirectories(logDir); // 디렉터리 생성
                System.out.println("로그 디렉터리 생성됨: " + logDir.toString());
            }

            // 로그 파일에 메시지 기록
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
                writer.write(message);
                writer.newLine(); // 새로운 줄 추가
                writer.flush(); // 로그를 파일에 즉시 씀
                System.out.println("로그 파일에 메시지 기록됨: " + message);
            } catch (IOException e) {
                System.err.println("로그 파일에 메시지를 기록하는 중에 문제가 발생했습니다.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("로그 디렉터리 생성 중에 문제가 발생했습니다.");
            e.printStackTrace();
        }
    }

    @Autowired
    Team2Service team2Service;

    @GetMapping("/hello2")
    public List<Team2Entity> list() {
		List<Team2Entity> r = team2Service.getMessages();
		return r;	
	}
    
    //C
    @PostMapping("/hello2")
    public void createData(@RequestBody Team2Entity team2Entity) {
        team2Service.createData(team2Entity);
    }

    //U
    @PutMapping("/hello2/{id}")
    public void updateData(@PathVariable Integer id, @RequestBody Team2Entity team2Entity) {
        team2Service.updateData(id, team2Entity);
    }

    //D
    @DeleteMapping("/hello2/{id}")
    public void deleteData(@PathVariable Integer id) {
        team2Service.deleteData(id);
    }
}

