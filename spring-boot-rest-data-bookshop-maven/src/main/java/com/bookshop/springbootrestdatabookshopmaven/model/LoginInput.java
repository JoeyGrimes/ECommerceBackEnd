package com.bookshop.springbootrestdatabookshopmaven.model;

import lombok.ToString;

@ToString
public class LoginInput {

	private String email;
	private String password;
	public LoginInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginInput(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	@Override
	public String toString() {
		return "LoginInput [email=" + email + ", password=" + password + "]";
	}
	
	
}
