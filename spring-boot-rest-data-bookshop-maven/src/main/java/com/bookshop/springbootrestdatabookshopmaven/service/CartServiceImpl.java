package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.dao.AccountDao;
import com.bookshop.springbootrestdatabookshopmaven.dao.BookDao;
import com.bookshop.springbootrestdatabookshopmaven.dao.CartDao;
import com.bookshop.springbootrestdatabookshopmaven.dao.TransactionHistoryDao;
import com.bookshop.springbootrestdatabookshopmaven.entity.AccountEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.CartEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.TransactionHistoryEntity;
import com.bookshop.springbootrestdatabookshopmaven.pojo.AccountPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.CartPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.TransactionHistoryPojo;

@Service

public class CartServiceImpl implements CartService {

	public CartServiceImpl() {
	}

	@Autowired
	CartDao cartDao;
	@Autowired
	TransactionHistoryDao transactionHistoryDao;
	@Autowired 
	BookDao bookDao;
	@Autowired
	AccountDao accountDao;
	

	@Override
	public CartPojo addToCart(int accountId, int bookId, int quantity) {
		BookEntity book = bookDao.findByBookId(bookId);
		CartPojo cartpojo = new CartPojo();
		BookPojo currentbook = new BookPojo();
		BeanUtils.copyProperties(book, currentbook);
		Optional<AccountEntity> account = Optional.ofNullable(accountDao.findByAccountId(accountId));
		AccountPojo accountPojo = new AccountPojo();
		if(account.isPresent()) {
			BeanUtils.copyProperties(account.get(), accountPojo);
			cartpojo.setBookId(currentbook.getBookId());
			cartpojo.setBookTitle(currentbook.getBookTitle());
			cartpojo.setCost(currentbook.getCost());
			cartpojo.setAccountId(accountPojo.getAccountId());
			cartpojo.setQuantity(quantity);
			CartEntity newCartEntity = new CartEntity();
			BeanUtils.copyProperties(cartpojo, newCartEntity); // copying the book pojo into a book entity
			cartDao.saveAndFlush(newCartEntity); // save the entity object in the db
													// this will return the autogenretaed primary key

		}
		return cartpojo;
		
		
	
	}

	@Override
	public void removeFromCart(int bookId, int accountId) {

		cartDao.deleteByBookIdAndAccountId(bookId, accountId);
	}

	
	//This needs to be edited, I need to insert each individual item on the cart into a LIST. a list of Pojos needs to be pulled,
	//saved to transaction table, then the cart delete by can be called
	@Override
	public void Checkout(int accountId) {
		List<CartEntity> FetchedCartItems = cartDao.findAllByAccountId(accountId);
		List<TransactionHistoryEntity> transactions = new ArrayList<TransactionHistoryEntity>();
		BeanUtils.copyProperties(FetchedCartItems, transactions);
		transactionHistoryDao.saveAllAndFlush(transactions);
		cartDao.deleteByAccountId(accountId);
			
	}

	@Override
	public List<CartPojo> viewCart(int accountId) {
		List<CartEntity> allCartEntity = cartDao.findAllByAccountId(accountId);
		List<CartPojo> allCartItems = new ArrayList<CartPojo>();
		
		allCartEntity.forEach((eachEntity)->allCartItems.add(new CartPojo(eachEntity.getAccountId(), eachEntity.getCost(), eachEntity.getQuantity(), eachEntity.getBookTitle(), eachEntity.getBookId())));
	
		return allCartItems;
	}

}
