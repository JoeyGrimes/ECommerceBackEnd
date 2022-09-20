package com.bookshop.springbootrestdatabookshopmaven.entity;

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
	@Column(name = "accountid")
	private int accountId;

	@Column(name = "cost")
	private int cost;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "booktitle")
	private String bookTitle;

	@Column(name = "bookId")
	private int bookid;
	
	@Column(name = "date")
	private String date;


	}

