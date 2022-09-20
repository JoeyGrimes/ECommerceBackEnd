package com.bookshop.springbootrestdatabookshopmaven.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.springbootrestdatabookshopmaven.pojo.AccountPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;
import com.bookshop.springbootrestdatabookshopmaven.service.AccountService;
import com.bookshop.springbootrestdatabookshopmaven.service.BookService;

import models.LoginInput;
import models.LoginOutput;
import models.ViewAccountInput;

@RestController
@RequestMapping("api")
public class MasterController {

	@Autowired // we are telling springframework to search for a class that implemenets this
				// interface "bookservice"
	// and make an object out of it in this class
	// the class implementation has to be annotated with @component in order to be a
	// piece of this process
	BookService bookService;
	@Autowired
	AccountService accountService;
	
	

	// Read -getAllBooks - @GetMapping
	// http://localhost:6666/api/books - get
	@GetMapping("books")
	public List<BookPojo> getAllBooks() {
		// call the corresponding getAllBooks method of the service layer
		// for that we need to create an object of the service layer
		// but with spring framework we can tell the framework to create the object for
		// us
		return bookService.getAllBooks();

	}

	// Read - an Account - @GetMapping
	// http://localhost:6666/api/books/14
	// ^ bookId

	@PostMapping("/viewaccount")
	public AccountPojo viewAccount (@Valid @RequestBody ViewAccountInput viewaccountinput) {
		System.out.println(viewaccountinput.getAccountId());
		return accountService.viewAccount(viewaccountinput.getAccountId());
		
	}

	// Create - addBook - PostMapping
	@PostMapping("")
	public AccountPojo register(@Valid @RequestBody AccountPojo accountpojo) {
		return accountService.register(accountpojo);
	}
	@PostMapping("/login")
	public LoginOutput Login(@Valid @RequestBody LoginInput logininput) {
		
		int accountid = accountService.login(logininput.getEmail(), logininput.getPassword());
		return new LoginOutput(accountid);
	}

	// Update - updateBook - PutMapping
	@PutMapping("")
	public BookPojo updateBook(@RequestBody BookPojo updatedBook) {

		return bookService.updateBook(updatedBook);
	}
	
	// Delete - deleteBook - DeleteMapping
	@DeleteMapping("/{bid}")
	public void deleteBook(@PathVariable("bid") int bookId) {
		bookService.deleteBook(bookId);
	}

}

