package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.dao.TransactionHistoryDao;
import com.bookshop.springbootrestdatabookshopmaven.entity.AccountEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.TransactionHistoryEntity;
import com.bookshop.springbootrestdatabookshopmaven.pojo.AccountPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.TransactionHistoryPojo;
@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

	public TransactionHistoryServiceImpl() {
		}
	@Autowired
	TransactionHistoryDao transactionHistoryDao;
	
	@Override
	public List<TransactionHistoryPojo> viewTransactionHistory(int accountid) {
			List<TransactionHistoryEntity> allTransactionsEntity = transactionHistoryDao.findAllByAccountId(accountid);
			List<TransactionHistoryPojo> allTransactionsPojo = new ArrayList<TransactionHistoryPojo>();
			
			allTransactionsEntity.forEach((eachEntity)->allTransactionsPojo.add(new TransactionHistoryPojo(eachEntity.getAccountId(), eachEntity.getCost(), eachEntity.getQuantity(), eachEntity.getBookTitle(), eachEntity.getBookid(), eachEntity.getDate())));
		
			return allTransactionsPojo;
		}
	}


