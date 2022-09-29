package com.bookshop.springbootrestdatabookshopmaven.model;

import lombok.ToString;

@ToString
public class DeleteCartItemInput {
	private int bookId;
	private int accountId;
	public DeleteCartItemInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeleteCartItemInput(int bookId, int accountId) {
		super();
		this.bookId = bookId;
		this.accountId = accountId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	
	
}
