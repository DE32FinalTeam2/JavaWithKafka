package com.websocket.socket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.websocket.socket.entity.Team2Entity;
import com.websocket.socket.message.HelloMessage;

@Mapper
public interface Team2Mapper {
    List<Team2Entity> findAll();

    void createData(int id, String chatTime, String username, String chattingContent, String ip, boolean chatCheck);
    
    void updateData(int id, String chatTime, String username, String chattingContent, String ip, boolean chatCheck);

    void deleteData(int id);
}