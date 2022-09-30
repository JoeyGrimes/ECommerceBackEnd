package com.bookshop.springbootrestdatabookshopmaven.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookshop.springbootrestdatabookshopmaven.entity.BookEntity;
import com.bookshop.springbootrestdatabookshopmaven.entity.CartEntity;

@Repository
public interface CartDao extends JpaRepository<CartEntity, Integer> {

	public void deleteAllByAccountId(int accountId);

	public void deleteByBookIdAndAccountId(int bookId, int accountId);

	public List<CartEntity> findAllByAccountId(int accountId);

//	@Query ("SELECT MAX(orderNo) FROM current_cart WHERE accountid = :#{customer_accounts.accountid}")
//	public CartEntity findByAccountId(@Param("accountid") int accountId);
	
	@Query(value = "SELECT max(orderNo) FROM current_cart", nativeQuery = true)
	int getMaxOrderNo();
	
//	@Query("select u from User u where u.firstname = :#{#customer.firstname}")
//	List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
	
}
