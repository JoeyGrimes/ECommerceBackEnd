package com.bookshop.springbootrestdatabookshopmaven.model;

import lombok.ToString;

@ToString
public class ViewAccountInput {

	private int accountId;

	public ViewAccountInput() {
		super();
		
	}

	public ViewAccountInput(int accountId) {
		super();
		this.accountId = accountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	
}
