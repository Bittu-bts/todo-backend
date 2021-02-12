package com.bts.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	List<Todo> findAll();

}
