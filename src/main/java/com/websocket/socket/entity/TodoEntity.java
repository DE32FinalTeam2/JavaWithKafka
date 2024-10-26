package com.websocket.socket.entity;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;


@Setter
@Getter
@ToString
public class TodoEntity {
    private Integer id;
    private String chat_time; // datetime을 LocalDateTime으로 수정
    private String username;
    private String chatting_content; // 오타 수정: chatting_cotent -> chatting_content
    private String chat_ip;
    private String chat_check;
}