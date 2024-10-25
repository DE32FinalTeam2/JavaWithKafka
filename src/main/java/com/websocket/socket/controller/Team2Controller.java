package com.websocket.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.websocket.socket.entity.Team2Entity;
import com.websocket.socket.service.Team2Service;

import java.util.List;

@RestController
@RequestMapping("/messages") // 모든 메서드의 기본 URL 설정
public class Team2Controller {

    @Autowired
    private Team2Service team2Service;

    // C - Create
    @PostMapping
    public void createData(@RequestBody Team2Entity team2Entity) {
        team2Service.createData(team2Entity);
    }

    // R - Read All
    @GetMapping
    public List<Team2Entity> list() {
        System.out.println("controller");
        return team2Service.getMessages();
    }

    // U - Update
    @PutMapping("/{id}")
    public void updateData(@PathVariable Integer id, @RequestBody Team2Entity team2Entity) {
        team2Service.updateData(id, team2Entity);
    }

    // D - Delete
    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable Integer id) {
        team2Service.deleteData(id);
    }
}
