package com.websocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.websocket.socket.message.HelloMessage;

@Mapper
public interface Team2Mapper {
    List<HelloMessage> findAll();   
}
