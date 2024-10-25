package com.websocket.socket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websocket.socket.entity.Team2Entity;
import com.websocket.socket.mapper.Team2Mapper;
import com.websocket.socket.message.HelloMessage;

@Service
public class Team2Service {

  @Autowired
  Team2Mapper team2Mapper;

  public List<Team2Entity> getMessages() {
	  List<Team2Entity> r = team2Mapper.findAll();
	  return r;
	}
  public void createData(Team2Entity team2Entity) {
    team2Mapper.createData(team2Entity.getId(), team2Entity.getChatTime(), team2Entity.getUsername(), team2Entity.getChattingContent(), team2Entity.getIp(), team2Entity.isChatCheck());
  }

  public void updateData(Integer id, Team2Entity team2Entity) {
    team2Mapper.updateData(team2Entity.getId(), team2Entity.getChatTime(), team2Entity.getUsername(), team2Entity.getChattingContent(), team2Entity.getIp(), team2Entity.isChatCheck());
  }

  public void deleteData(Integer id) {
    team2Mapper.deleteData(id);
  }

}

