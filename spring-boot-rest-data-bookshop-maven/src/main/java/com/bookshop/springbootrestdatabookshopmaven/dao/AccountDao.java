package com.bookshop.springbootrestdatabookshopmaven.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookshop.springbootrestdatabookshopmaven.entity.AccountEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
import com.bookshop.springbootrestdatabookshopmaven.pojo.AccountPojo;
@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Integer>{

	
	AccountEntity findByEmailAndPassword(String email, String password);
	
	
	AccountEntity findByAccountId(int accountId);
	
	
	
}


