package com.bookshop.springbootrestdatabookshopmaven.service;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.entity.AccountEntity;
import com.bookshop.springbootrestdatabookshopmaven.model.CreateAccountInput;
import com.bookshop.springbootrestdatabookshopmaven.model.CreateAccountOutput;
import com.bookshop.springbootrestdatabookshopmaven.pojo.AccountPojo;


public interface AccountService {
	
	public  AccountPojo viewAccount(int accountid);
	
	public AccountPojo login(String email, String password);
	
	public AccountPojo register(AccountPojo accountpojo);

	
	
		
	
}
