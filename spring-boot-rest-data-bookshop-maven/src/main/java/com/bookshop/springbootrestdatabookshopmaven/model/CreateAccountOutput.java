package com.bookshop.springbootrestdatabookshopmaven.model;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class CreateAccountOutput {
	private int accountId;
	
	private String email;
	
	private String password;

	private String firstname;
	
	private String lastname;

	public CreateAccountOutput() {
		super();
		
	}

	public CreateAccountOutput(int accountId, String email, String password, String firstname, String lastname) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	
	
}
