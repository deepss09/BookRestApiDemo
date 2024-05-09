package com.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.entities.Books;

public interface BookRepository  extends CrudRepository<Books,Integer>{

	public Books findById(int id);
	
}
