package com.bookshop.springbootrestdatabookshopmaven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="book")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Id is the primary auto generated key
	@Column(name ="bookid")
		private int bookId;
	
	@Column(name = "booktitle")
	 private String bookTitle;
	
	@Column(name = "bookauthor")
	 private String bookAuthor;
	
	@Column(name = "cost")
	 private int bookCost;
	
	@Column(name="bookimageurl")
	 private String bookImageUrl;
	
	
	
	
	
}
	//default constructor
	//parametrized constructor
	//getters and setters
	//to string