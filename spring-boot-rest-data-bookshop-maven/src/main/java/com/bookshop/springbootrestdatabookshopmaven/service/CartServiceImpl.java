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
	public void addToCart(CartPojo cartpojo) {
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

	@Override
	public void Checkout(int accountId, TransactionHistoryPojo transactionhistorypojo) {
		cartDao.deleteByAccountId(accountId);
		TransactionHistoryEntity transactionHistoryEntity = new TransactionHistoryEntity();
		BeanUtils.copyProperties(transactionhistorypojo, transactionHistoryEntity);
		transactionHistoryDao.saveAndFlush(transactionHistoryEntity);
	}

	@Override
	public List<CartPojo> viewCart(int accountId) {
		List<CartEntity> allProductsEntity = cartDao.findAll();
		List<CartPojo> allCartProducts = new ArrayList<CartPojo>();

		allProductsEntity.forEach((eachEntity) -> allCartProducts
				.add(new CartPojo(eachEntity.getAccountId(), eachEntity.getCost(), eachEntity.getQuantity(),
						eachEntity.getBookTitle(), eachEntity.getBookId(), eachEntity.getDate())));

		return allCartProducts;
	}

}
