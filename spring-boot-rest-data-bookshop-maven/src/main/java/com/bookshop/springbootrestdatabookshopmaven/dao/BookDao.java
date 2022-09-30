package com.bookshop.springbootrestdatabookshopmaven.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;



@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer>{
	BookEntity findByBookId(int bookId);
	
	

	
	
}
