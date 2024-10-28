package com.websocket.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websocket.socket.entity.TodoEntity;
import com.websocket.socket.service.TodoService;

import java.util.List;

@RestController
public class TodoController{
	
	@Autowired
	TodoService todoService;	

	@GetMapping("/logs")
	public List<TodoEntity> list() {
		System.out.println("[Controller]");
		List<TodoEntity> r = todoService.getTodos();
		return r;	
	}
	
	@GetMapping("/logs/{id}")
	public TodoEntity find(@PathVariable Integer id) {
		TodoEntity r = todoService.findById(id);
		return r;	
	}

	//C - INSERT
	@PostMapping("/logs")
	public void insert(@RequestBody TodoEntity todoEntity){
		todoService.insertEntity(todoEntity.getChat_time(), todoEntity.getUsername(), todoEntity.getChatting_content(),todoEntity.getChat_ip(),todoEntity.getChat_check());
	}

	//U - UPDATE
	@PutMapping("/logs/{id}")
	public void update(@PathVariable Integer id, @RequestBody TodoEntity todoEntity){
		todoService.updateById(id,todoEntity);
		
	}

	//D - DELETE
	@DeleteMapping("/logs/{id}")
	public void delete(@PathVariable Integer id){
		todoService.deleteById(id);		
	}
}
