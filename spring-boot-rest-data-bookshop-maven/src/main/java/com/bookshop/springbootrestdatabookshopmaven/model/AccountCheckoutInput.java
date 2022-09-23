package com.bookshop.springbootrestdatabookshopmaven.model;




public class AccountCheckoutInput {
	private int accountId;

	public AccountCheckoutInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountCheckoutInput(int accountId) {
		super();
		this.accountId = accountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "AccountCheckoutInput [accountId=" + accountId + "]";
	}
	
	
}
