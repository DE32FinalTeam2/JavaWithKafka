package com.websocket.socket.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Team2Entity {
    private int id;
    //private int offset;
    private String chatTime;
    private String username;
    private String chattingContent;
    private String ip;
    private boolean chatCheck;
    
}
// helloMessage.getChattime(), helloMessage.getUsername(), helloMessage.getChattingcontent(), helloMessage.getChatip(), helloMessage.getchatcheck()