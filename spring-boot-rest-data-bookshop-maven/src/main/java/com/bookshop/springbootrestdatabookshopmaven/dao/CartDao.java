package com.bookshop.springbootrestdatabookshopmaven.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.CartEntity;

@Repository
public interface CartDao extends JpaRepository<CartEntity, Integer> {

	
	
	
	public void deleteByBookIdAndAccountId(int bookId, int accountId);

	public void deleteByAccountId(int accountId);
	
	public List<CartEntity> findAllByAccountId(int accountId);
	
}
