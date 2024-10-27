package com.websocket.socket.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Team2Entity {
    private int id;
    //private int offset;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime chatTime;
    private String username;
    private String chattingContent;
    private String ip;
    private boolean chatCheck;
    
}
// helloMessage.getChattime(), helloMessage.getUsername(), helloMessage.getChattingcontent(), helloMessage.getChatip(), helloMessage.getchatcheck()