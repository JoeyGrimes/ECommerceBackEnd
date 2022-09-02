package service;

import java.util.List;

import Pojo.AccountPojo;
import Pojo.LoginPojo;
import Pojo.TransactionPojo;

//CRUD
public interface AccountService {
	// List all accounts
	List<AccountPojo> listAllAccounts();

	AccountPojo viewAccount(int idNumber);

	void depositCash(int withdraw);

	void withdrawCash(int deposit);

	void transferMoney(int amount, int UserID, int otherID);
	
	List<TransactionPojo> viewTransactions(int userID);

	
	

}
