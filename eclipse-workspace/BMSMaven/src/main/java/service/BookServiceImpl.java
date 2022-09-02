package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.ApplicationException;
import dao.BookDao;
import dao.BookDaoJdbcImpl;
import Pojo.BookPojo;

public class BookServiceImpl implements BookService{

	// Logging Step 1 - obtain an instance of Logger
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	
	// fill in the code later for each methods 
	// will fill in after the dao layer is done
	
	// BookDao interface reference variable
	BookDao bookDao; // this is the preferred way as the class is abstracted through the interface reference variable
	
	//BookDaoArrayImpl bookDao; // is highly not recomended as we need to abstract the class
		
	public BookServiceImpl() {
		// the interface reference variable points to the jdbc implementation class
		bookDao = new BookDaoJdbcImpl();
	}

	// the methods in my service layer don't do anything much, they just call the respective dao methods

	public List<BookPojo> getAllBooks()throws ApplicationException {
		logger.info("Entered getAllBooks() in service layer...");
		return bookDao.getAllBooks();
	}


	public BookPojo addBook(BookPojo bookPojo)throws ApplicationException {
		logger.info("Entered getAllBooks() in service layer...");
		return bookDao.addBook(bookPojo);
	}


	public BookPojo updateBook(BookPojo bookPojo)throws ApplicationException {
		logger.info("Entered getAllBooks() in service layer...");
		return bookDao.updateBook(bookPojo);
	}


	public void deleteBook(int bookId)throws ApplicationException {
		logger.info("Entered getAllBooks() in service layer...");
		bookDao.deleteBook(bookId);
	}

	
	public BookPojo getABook(int bookId)throws ApplicationException {
		logger.info("Entered getAllBooks() in service layer...");
		return bookDao.getABook(bookId);
	}

}