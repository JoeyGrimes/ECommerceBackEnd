package service;

import java.util.List;

import Pojo.AccountPojo;
import Pojo.LoginPojo;
import dao.LoginDao;
import dao.LoginDaoJdbcImpl;
import exception.ApplicationException;

public class LoginServiceImpl implements LoginService{
	 LoginDao logindao;
		
	
	
	public LoginServiceImpl() {
		logindao = new LoginDaoJdbcImpl();
	}


	public LoginPojo createAccount(LoginPojo loginpojo) {
		
		return logindao.createAccount(loginpojo);
	}






	

}
