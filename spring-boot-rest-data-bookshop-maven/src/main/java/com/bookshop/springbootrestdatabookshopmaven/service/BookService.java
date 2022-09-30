package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;

public interface BookService   {
	List<BookPojo> getAllBooks();
	
}