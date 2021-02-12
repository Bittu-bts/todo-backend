package com.bts.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bts.entity.Todo;
import com.bts.services.TodoService;


@RestController
@CrossOrigin("*")
public class TodoController {
	
	@Autowired
	TodoService todoservice;
	
	@RequestMapping(value="/todos",method = RequestMethod.GET)
	public List<Todo> getTodos() { 
		return todoservice.getAllTodo();
	}
	@RequestMapping(value="/todo/{id}",method = RequestMethod.GET)
	public Optional<Todo> getTodoById(@PathVariable("id") String id) {
		return todoservice.getTodoById(Integer.parseInt(id));
	}
	
	
	@RequestMapping(value="/todo",method = RequestMethod.POST)
	public Todo addTodos(@RequestBody Todo todo) {
		return todoservice.addTodo(todo);
	}
	
	@RequestMapping(value="/todo/{id}",method = RequestMethod.PUT)
	public Optional<Todo> addTodos(@PathVariable("id") String id, @RequestBody Todo todo) {
		return todoservice.updateTodo(Integer.parseInt(id), todo);
	}
	@RequestMapping(value="/todostatus/{id}",method = RequestMethod.PUT)
	
	public Optional<Todo> updateTodoStatus(@PathVariable("id") String id, @RequestBody Todo todo) {
		return todoservice.updateTodoStatus(Integer.parseInt(id));
	}
	@RequestMapping(value="/todo/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		todoservice.deleteById(Integer.parseInt(id));
		return ResponseEntity.ok().body("Todo" + id + "has been removed");
	}
	@RequestMapping(value="/todos/{ids}",method =RequestMethod.DELETE)
	public ResponseEntity<?> deleteByIds(@PathVariable("ids") List<String> ids) {
		ids.forEach(d->{
			if(todoservice.existById(Integer.parseInt(d))) {
				todoservice.deleteById(Integer.parseInt(d));
			}
		});
		
		return ResponseEntity.ok().body("Todo has been removed");
	}

}
