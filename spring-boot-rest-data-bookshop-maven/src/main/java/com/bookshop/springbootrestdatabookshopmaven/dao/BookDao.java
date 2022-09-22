package com.bookshop.springbootrestdatabookshopmaven.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;



@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer>{
	BookEntity findByBookId(int bookId);
	
	
//SpringJPA will provide the implementation for the basic CRUD operations on the book table in database\
//create read update delete
	
	//When I work with customized queries, I dont have to make an implementation class, I only have to write finder methods
	//JPA is simplifying everything
	
	
}
