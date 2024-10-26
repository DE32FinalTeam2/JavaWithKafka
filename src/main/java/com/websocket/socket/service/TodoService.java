package com.websocket.socket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websocket.socket.entity.TodoEntity;
import com.websocket.socket.mapper.TodoMapper;

import java.util.List;

@Service
public class TodoService {

	@Autowired
	TodoMapper todoMapper;

	public List<TodoEntity> getTodos() {
		System.out.println("[service] findAll");
		List<TodoEntity> todos = todoMapper.findAll();
		System.out.println("[todos]:" + todos.size());
		return todos;
	}

  public TodoEntity findById(Integer id) {
    return todoMapper.findById(id);
  }

public void insertEntity(String subject, String body, Boolean completed) {
	todoMapper.insertEntity(subject, body, completed);
	// }
	//throw new UnsupportedOperationException("Unimplemented method 'insertEntity'");
}

public void updateById(int id, TodoEntity todoEntity) {
	todoEntity.setId(id);
	todoMapper.updateEntity(todoEntity);
}

public void deleteById(Integer id) {
	todoMapper.deleteEntity(id);
}




}

    


