package com.bookshop.springbootrestdatabookshopmaven.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name = "transactionhistory")
public class TransactionHistoryEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id is the primary auto generated key
	@Column(name = "transactionno")
	private int transactionNo;
	
	@Column(name = "orderno")
	private int orderNo;
	
	@Column(name = "accountid")
	private int accountId;

	@Column(name = "book")
	private String bookTitle;
	
	@Column(name = "bookid")
	private int bookId;
	
	
	@Column(name = "cost")
	private int bookCost;

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "date")
	private LocalDateTime date = LocalDateTime.now();
	
	}

