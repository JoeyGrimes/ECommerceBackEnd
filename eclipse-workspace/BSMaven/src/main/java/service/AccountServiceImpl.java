package service;

import java.util.List;

import Pojo.AccountPojo;
import Pojo.LoginPojo;
import Pojo.TransactionPojo;
import dao.AccountDao;
import dao.AccountDaoJdbcImpl;

public class AccountServiceImpl implements AccountService {
	AccountDao accountDao;

	public AccountServiceImpl() {

		accountDao = new AccountDaoJdbcImpl();
	}

	public List<AccountPojo> listAllAccounts() {
		// TODO Auto-generated method stub
		return accountDao.listAllAccounts();
//	
	}

	public AccountPojo viewAccount(int idNumber) {
		return accountDao.viewAccount(idNumber);
	}

	public void depositCash(int withdraw) {
		// TODO Auto-generated method stub

	}

	public void withdrawCash(int deposit) {
		// TODO Auto-generated method stub

	}

	public void transferMoney(int amount, int UserID, int otherID) {
		// TODO Auto-generated method stub
		
	}

	public List<TransactionPojo> viewTransactions(int userID) {
		// TODO Auto-generated method stub
		return accountDao.viewTransactions(userID);
	}

}

//
//	public AccountPojo viewAccount(int idNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}
