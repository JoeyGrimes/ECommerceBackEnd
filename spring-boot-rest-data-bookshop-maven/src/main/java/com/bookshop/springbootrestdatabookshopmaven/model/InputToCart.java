
package com.bookshop.springbootrestdatabookshopmaven.model;

import lombok.ToString;

@ToString
public class InputToCart {
	private int accountId;
	private int bookId;
	private int quantity;
	public InputToCart() {
		super();
		
	}
	public InputToCart(int accountId, int bookId, int quantity) {
		super();
		this.accountId = accountId;
		this.bookId = bookId;
		this.quantity = quantity;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
