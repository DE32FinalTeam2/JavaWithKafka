package com.websocket.socket.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.websocket.socket.entity.TodoEntity;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<TodoEntity> findAll();

    TodoEntity findById(Integer id);

    // void insertEntity(String subject, String body, Boolean completed);

    void deleteEntity(Integer id);

    void updateEntity(TodoEntity todoEntity);

    void insertEntity(String chat_time, String username, String chatting_content, String chat_ip, String chat_check);

    // void insertEntity(TodoEntity todoEntity);
}