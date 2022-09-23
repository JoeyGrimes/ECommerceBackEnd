package com.bookshop.springbootrestdatabookshopmaven.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.springbootrestdatabookshopmaven.model.AccountCheckoutInput;
import com.bookshop.springbootrestdatabookshopmaven.model.CreateAccountInput;
import com.bookshop.springbootrestdatabookshopmaven.model.CreateAccountOutput;
import com.bookshop.springbootrestdatabookshopmaven.model.DeleteCartItemInput;
import com.bookshop.springbootrestdatabookshopmaven.model.InputToCart;
import com.bookshop.springbootrestdatabookshopmaven.model.LoginInput;
import com.bookshop.springbootrestdatabookshopmaven.model.LoginOutput;
import com.bookshop.springbootrestdatabookshopmaven.model.ViewAccountInput;
import com.bookshop.springbootrestdatabookshopmaven.pojo.AccountPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.BookPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.CartPojo;
import com.bookshop.springbootrestdatabookshopmaven.pojo.TransactionHistoryPojo;
import com.bookshop.springbootrestdatabookshopmaven.service.AccountService;
import com.bookshop.springbootrestdatabookshopmaven.service.BookService;
import com.bookshop.springbootrestdatabookshopmaven.service.CartService;
import com.bookshop.springbootrestdatabookshopmaven.service.TransactionHistoryService;

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
	@GetMapping("/books")
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
	
	@PostMapping("/viewcurrentcart")
	public List<CartPojo> viewCurrentCart(@Valid @RequestBody ViewAccountInput viewaccountinput) {
		return cartService.viewCart(viewaccountinput.getAccountId());
		
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
	
	@PostMapping("/checkout")
	public void CheckoutItems (@Valid @RequestBody AccountCheckoutInput accountCheckoutInput) {
		cartService.Checkout(accountCheckoutInput.getAccountId());
		
	}
	
	@PostMapping("/addToCart")
	public CartPojo addToCart(@Valid @RequestBody InputToCart inputToCart) {
		return cartService.addToCart(inputToCart.getAccountId(), inputToCart.getBookId(), inputToCart.getQuantity());
	}
	
	//works
	@PostMapping("/login")
	public LoginOutput login(@Valid @RequestBody LoginInput logininput) {
		
		int accountid = accountService.login(logininput.getEmail(), logininput.getPassword());
		return new LoginOutput(accountid);
	}

	
	// --testing
	@PostMapping("removeCartItem")
	public void deleteItem(@Valid @RequestBody DeleteCartItemInput deleteCartItemInput) {
		cartService.removeFromCart(deleteCartItemInput.getBookId(), deleteCartItemInput.getAccountId());
	}

}

