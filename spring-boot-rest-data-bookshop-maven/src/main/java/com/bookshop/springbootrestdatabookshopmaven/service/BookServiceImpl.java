package com.bookshop.springbootrestdatabookshopmaven.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bookshop.springbootrestdatabookshopmaven.dao.AccountDao;
import com.bookshop.springbootrestdatabookshopmaven.dao.BookDao;
import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
@CommonsLog
@AllArgsConstructor
@NoArgsConstructor
@Service // this tells the spring framenwork that this class is a bean
public class BookServiceImpl implements BookService{

	
	
	// BookDao interface reference variable
	@Autowired
	BookDao bookDao; // this is the preferred way as the class is abstracted through the interface reference variable
	
		
	@Override
	public List<BookPojo> getAllBooks(){
		List<BookEntity> allBooksEntity = bookDao.findAll();
		List<BookPojo> allBooksPojo = new ArrayList<BookPojo>();
		
		allBooksEntity.forEach((eachEntity)->allBooksPojo.add(new BookPojo(eachEntity.getBookId(), eachEntity.getBookTitle(), eachEntity.getBookAuthor(), eachEntity.getBookCost(), eachEntity.getBookImageUrl())));
		
		return allBooksPojo;
	}

}
