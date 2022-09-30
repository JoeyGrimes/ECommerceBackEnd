package com.bookshop.springbootrestdatabookshopmaven.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import lombok.extern.apachecommons.CommonsLog;

@Transactional
@RestController
@CommonsLog
@RequestMapping("api")
@CrossOrigin
public class MasterController {

	@Autowired
	BookService bookService;
	@Autowired
	AccountService accountService;
	@Autowired
	CartService cartService;
	@Autowired
	TransactionHistoryService transactionHistoryService;

	
	// http://localhost:3333/api/books
	@GetMapping("/books")
	public List<BookPojo> getAllBooks() {
		log.info("entered getAllBooks");
		log.info("exited getAllBooks");
		return bookService.getAllBooks();

	}

	
	@PostMapping("/viewaccount")
	public AccountPojo viewAccount(@Valid @RequestBody ViewAccountInput viewaccountinput) {
		log.info("entered viewaccount:" + viewaccountinput);
		log.info("exited viewaccount");
		return accountService.viewAccount(viewaccountinput.getAccountId());

	}

	@PostMapping("/viewcurrentcart")
	public List<CartPojo> viewCurrentCart(@Valid @RequestBody ViewAccountInput viewaccountinput) {
		log.info("entered viewcurrentcart" + viewaccountinput);
		log.info("exited viewaccount");
		return cartService.viewCart(viewaccountinput.getAccountId());

	}

	@PostMapping("/transactionhistory")
	public List<TransactionHistoryPojo> viewTransactionHistory(@Valid @RequestBody ViewAccountInput viewaccountinput) {
		log.info("entered viewatransactionhistory" + viewaccountinput);
		log.info("entered viewatransactionhistory");

		return transactionHistoryService.viewTransactionHistory(viewaccountinput.getAccountId());

	}

	@PostMapping("")
	public AccountPojo registerAccount(@Valid @RequestBody AccountPojo newaccount) {
		log.info("entered registerAccount" + newaccount);
		log.info("exited registerAccount");
		return accountService.register(newaccount);

	}

	@PostMapping("/checkout")
	public void CheckoutItems(@Valid @RequestBody AccountCheckoutInput accountCheckoutInput) {
		log.info("entered CheckoutItems" + accountCheckoutInput);
		cartService.Checkout(accountCheckoutInput.getAccountId());

	}

	@PostMapping("/addToCart")
	public CartPojo addToCart(@Valid @RequestBody InputToCart inputToCart) {
		log.info("entered addToCart" + inputToCart);
		log.info("exited addToCart");
		return cartService.addToCart(inputToCart.getAccountId(), inputToCart.getBookId(), inputToCart.getQuantity());
	}

	@PostMapping("/login")
	public AccountPojo login(@Valid @RequestBody LoginInput logininput) {
		log.info("entered login" + logininput);
		log.info("exited login");
		AccountPojo accountpojo = accountService.login(logininput.getEmail(), logininput.getPassword());
		return accountpojo;
	}

	@PostMapping("/removeCartItem")
	public void deleteItem(@Valid @RequestBody DeleteCartItemInput deleteCartItemInput) {
		log.info("entered deleteItem" + deleteCartItemInput);
		log.info("exited deleteItem");
		cartService.removeFromCart(deleteCartItemInput.getBookId(), deleteCartItemInput.getAccountId());
	}

}
