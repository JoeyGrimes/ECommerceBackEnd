package dao;

import java.util.List;

import Pojo.AccountPojo;
import Pojo.LoginPojo;
import Pojo.TransactionPojo;
import exception.ApplicationException;

//CRUD
public interface AccountDao {
	// List all accounts
	List<AccountPojo> listAllAccounts();
	// Make a new account

	// view AccountDetails
	AccountPojo viewAccount(int idNumber);

	void depositCash(int depositCash, int UserID);

	void withdrawCash(int deposit, int UserID);

	void transferMoney(int amount, int UserID, int otherID);

	List<TransactionPojo> viewTransactions(int userID);
}
