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

import com.bookshop.springbootrestdatabookshopmaven.dao.BookDao;
import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;
import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;


@Service // this tells the spring framenwork that this class is a bean
public class BookServiceImpl implements BookService{

	
	
	// BookDao interface reference variable
	@Autowired
	BookDao bookDao; // this is the preferred way as the class is abstracted through the interface reference variable
	
		
	public BookServiceImpl() {
		// the interface reference variable points to the jdbc implementation class
		// this line is no longer needed after we have autowired bookDao
		// bookDao = new BookDaoJdbcImpl();
	}

	// the methods in my service layer don't do anything much, they just call the respective dao methods
	@Override
	public List<BookPojo> getAllBooks(){
		List<BookEntity> allBooksEntity = bookDao.findAll();
		List<BookPojo> allBooksPojo = new ArrayList<BookPojo>();
		
		allBooksEntity.forEach((eachEntity)->allBooksPojo.add(new BookPojo(eachEntity.getBookId(), eachEntity.getBookTitle(), eachEntity.getBookAuthor(), eachEntity.getBookCost(), eachEntity.getBookImageUrl())));
		
		return allBooksPojo;
	}

}
