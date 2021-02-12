package com.bts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.entity.Todo;
import com.bts.repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todorepository;
	
	public List<Todo> getAllTodo(){
		return todorepository.findAll();
	}
	public Todo addTodo(Todo todo) {
		return todorepository.save(todo);
	}
	public Boolean existById(Integer id) {
		return todorepository.existsById(id);
	}
	public Optional<Todo> getTodoById(Integer id) {
		return todorepository.findById(id);
	}
	public Optional<Todo> updateTodo(Integer id,Todo todo) {
		return todorepository.findById(id).map((d)->{
			d.setTask(todo.getTask());
			
		return todorepository.save(d);
			
		});
	}
	
	
	public Optional<Todo> updateTodoStatus(Integer id) {
		return todorepository.findById(id).map((d)->{
			d.setStatus(!d.getStatus());
			
		return todorepository.save(d);
			
		});
	}
	
	
	
	
	public void deleteById(Integer id) {
		todorepository.deleteById(id);
	}
	
}
