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
import com.bookshop.springbootrestdatabookshopmaven.pojo.TransactionHistoryPojo;
import com.bookshop.springbootrestdatabookshopmaven.service.AccountService;
import com.bookshop.springbootrestdatabookshopmaven.service.BookService;
import com.bookshop.springbootrestdatabookshopmaven.service.CartService;
import com.bookshop.springbootrestdatabookshopmaven.service.TransactionHistoryService;

import models.CreateAccountInput;
import models.CreateAccountOutput;
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
	@Autowired 
	CartService cartService;
	@Autowired
	TransactionHistoryService transactionHistoryService;
	
	

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

	
	//works
	@PostMapping("/viewaccount")
	public AccountPojo viewAccount (@Valid @RequestBody ViewAccountInput viewaccountinput) {
		System.out.println(viewaccountinput.getAccountId());
		return accountService.viewAccount(viewaccountinput.getAccountId());
		
	}
	
	@PostMapping("/transactionhistory")
	public List<TransactionHistoryPojo> viewTransactionHistory(@Valid @RequestBody ViewAccountInput viewaccountinput){
		return transactionHistoryService.viewTransactionHistory(viewaccountinput.getAccountId());
		
	}

	// --testing
	@PostMapping("")
	public AccountPojo registerAccount(@Valid @RequestBody AccountPojo newaccount) {
		 return accountService.register(newaccount);
		 
	}
	
	@PostMapping("{/bid}/checkout")
	public void Checkout() {
		
		
	}
	
	//works
	@PostMapping("/login")
	public LoginOutput login(@Valid @RequestBody LoginInput logininput) {
		
		int accountid = accountService.login(logininput.getEmail(), logininput.getPassword());
		return new LoginOutput(accountid);
	}

	
	// --testing
	@DeleteMapping("/{bid}/{bid}")
	public void deleteAccount(@PathVariable("bid") int bookId, @PathVariable("bid")int accountId) {
		cartService.removeFromCart(bookId, accountId);
	}

}

