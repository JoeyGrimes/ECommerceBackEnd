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
public class BookPojo {
	
	 private int bookId;
	 @NotNull
	 private String bookTitle;
	 @NotNull
	 private String bookAuthor;
	 @NotNull
	 private int bookCost;
	 @NotNull
	 private String bookImageUrl;
	
	
	
}
