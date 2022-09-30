package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.dao.TransactionHistoryDao;
import com.bookshop.springbootrestdatabookshopmaven.entity.AccountEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.TransactionHistoryEntity;
import com.bookshop.springbootrestdatabookshopmaven.pojo.AccountPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.TransactionHistoryPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
@CommonsLog
@AllArgsConstructor
@NoArgsConstructor
@Service

public class TransactionHistoryServiceImpl implements TransactionHistoryService {

	
	@Autowired
	TransactionHistoryDao transactionHistoryDao;
	
	@Override
	public List<TransactionHistoryPojo> viewTransactionHistory(int accountid) {
			List<TransactionHistoryEntity> allTransactionsEntity = transactionHistoryDao.findAllByAccountId(accountid);
			List<TransactionHistoryPojo> allTransactionsPojo = new ArrayList<TransactionHistoryPojo>();
			
			allTransactionsEntity.forEach((eachEntity)->allTransactionsPojo.add(new TransactionHistoryPojo(eachEntity.getTransactionNo(), eachEntity.getOrderNo(),eachEntity.getAccountId(), eachEntity.getBookCost(), eachEntity.getQuantity(), eachEntity.getBookTitle(), eachEntity.getBookId(), eachEntity.getDate())));
		
			return allTransactionsPojo;
		}
	
	
	}


