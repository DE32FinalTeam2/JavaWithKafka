package com.websocket.socket.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.websocket.socket.entity.Team2Entity;

@Mapper
public interface Team2Mapper {
    List<Team2Entity> findAll();

    void createData(int id, LocalDateTime chatTime, String username, String chattingContent, String ip, boolean chatCheck);
    
    void updateData(int id, String username, boolean chatCheck);

    void deleteData(int id);
}
