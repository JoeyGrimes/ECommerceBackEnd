package com.bookshop.springbootrestdatabookshopmaven.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookshop.springbootrestdatabookshopmaven.entity.AccountEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.TransactionHistoryEntity;
@Repository
public interface TransactionHistoryDao extends JpaRepository<TransactionHistoryEntity, Integer>{

	@Query(value = "SELECT * FROM transactionhistory WHERE accountid = ?1", nativeQuery = true)
	public List<TransactionHistoryEntity> findAllByAccountId(int accountId);
	
	
}
