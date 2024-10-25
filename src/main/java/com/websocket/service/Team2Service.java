package com.websocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websocket.entity.Team2Entity;
import com.websocket.mapper.Team2Mapper;
import com.websocket.socket.message.HelloMessage;

@Service
public class Team2Service {

  @Autowired
  Team2Mapper team2Mapper;

  public List<HelloMessage> getMessages() {
	  List<HelloMessage> r = team2Mapper.findAll();
	  return r;
	}
  public void createData(Team2Entity team2Entity) {
    team2Mapper.createData(team2Entity.getId(), team2Entity.getChatTime(), team2Entity.getUsername(), team2Entity.getChattingContent(), team2Entity.getIp(), team2Entity.getChatCheck());
  }

  public void updateData(Integer id, Team2Entity team2Entity) {
    team2Mapper.updateData(team2Entity.getId(), team2Entity.getChatTime(), team2Entity.getUsername(), team2Entity.getChattingContent(), team2Entity.getIp(), team2Entity.getChatCheck());
  }

  public void deleteData(Integer id) {
    team2Mapper.deleteData(id);
  }

}

