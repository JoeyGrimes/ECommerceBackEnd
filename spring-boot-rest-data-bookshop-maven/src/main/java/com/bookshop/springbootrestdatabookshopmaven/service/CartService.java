package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.CartPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.TransactionHistoryPojo;

public interface CartService {

public void addToCart(CartPojo cartpojo, int accountId);
	
	public void removeFromCart( int bookId , int accountId);
	
	public void Checkout(int accountId);
		
	public List<CartPojo> viewCart(int accountId);
			
}
