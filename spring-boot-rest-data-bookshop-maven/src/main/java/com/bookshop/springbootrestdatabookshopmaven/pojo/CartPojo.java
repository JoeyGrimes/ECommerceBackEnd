	package com.bookshop.springbootrestdatabookshopmaven.pojo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CartPojo {
	private int accountId;
	@NotNull
	private int cost;
	@NotNull
	private int quantity;
	@NotNull
	private String bookTitle;
	@NotNull
	private int bookId;
	@NotNull
	private String date;
	
	private AccountPojo accountpojo;
	private BookPojo bookpojo;
	
}
