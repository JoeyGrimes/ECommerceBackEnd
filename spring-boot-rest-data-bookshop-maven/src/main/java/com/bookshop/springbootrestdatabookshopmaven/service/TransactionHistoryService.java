package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.List;

import com.bookshop.springbootrestdatabookshopmaven.pojo.TransactionHistoryPojo;

public interface TransactionHistoryService {
	public List<TransactionHistoryPojo> viewTransactionHistory(int accountId);
	
	
	
}
