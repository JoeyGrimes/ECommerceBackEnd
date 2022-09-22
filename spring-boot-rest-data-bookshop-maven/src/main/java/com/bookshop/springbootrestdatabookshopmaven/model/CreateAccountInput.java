package com.bookshop.springbootrestdatabookshopmaven.model;

import javax.validation.constraints.NotNull;

public class CreateAccountInput {

	private int accountId;

	private String email;
	
	private String password;

	private String firstname;

	private String lastname;

	public CreateAccountInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateAccountInput(int accountId, String email, String password, String firstname, String lastname) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "CreateAccountInput [accountId=" + accountId + ", email=" + email + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	
	
	
}
