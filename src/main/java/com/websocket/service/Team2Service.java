package com.websocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websocket.mapper.Team2Mapper;
import com.websocket.socket.message.HelloMessage;

@Service
public class Team2Service {

    @Autowired
    Team2Mapper team2Mapper;

    public List<HelloMessage> getMessages() {
		List<HelloMessage> todos = team2Mapper.findAll();
		return todos;
	}
}

