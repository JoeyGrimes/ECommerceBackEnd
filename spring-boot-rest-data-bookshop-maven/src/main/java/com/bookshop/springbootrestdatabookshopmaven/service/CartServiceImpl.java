package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.dao.CartDao;
import com.bookshop.springbootrestdatabookshopmaven.dao.TransactionHistoryDao;
import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.CartEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.TransactionHistoryEntity;
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

	@Override
	public void addToCart(CartPojo cartpojo, int accountId, int bookId) {
		//need to save the current book selected by ID, this also needs to be passed as paramter
		//I might be able to do some cheeky logic where I copyproperties of the entities and save and flush
		
		
		
		//Another solution is the @join column by foreign key in the cart entity. If I can trim the extra unneccessary columns in my findAllBy then save and flush into the cart table
		//I just need to see a better example she shows
		
		
		
		CartEntity newCartEntity = new CartEntity();
		BeanUtils.copyProperties(cartpojo, newCartEntity); // copying the book pojo into a book entity
		cartDao.saveAndFlush(newCartEntity); // save the entity object in the db
												// this will return the autogenretaed primary key
		cartpojo.setAccountId(newCartEntity.getAccountId()); 

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
		
		allCartEntity.forEach((eachEntity)->allCartItems.add(new CartPojo(eachEntity.getAccountId(), eachEntity.getCost(), eachEntity.getQuantity(), eachEntity.getBookTitle(), eachEntity.getBookId(), eachEntity.getDate())));
	
		return allCartItems;
	}

}
