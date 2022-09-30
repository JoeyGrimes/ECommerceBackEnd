package com.bookshop.springbootrestdatabookshopmaven.model;

import lombok.ToString;

@ToString
public class LoginOutput {
	private int accountid;

	public LoginOutput() {
		super();
		
	}

	public LoginOutput(int accountid) {
		super();
		this.accountid = accountid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	@Override
	public String toString() {
		return "LoginOutput [accountid=" + accountid + "]";
	}
	
	
}
