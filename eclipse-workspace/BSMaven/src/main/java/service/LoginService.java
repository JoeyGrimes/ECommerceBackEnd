package service;

import java.util.List;

import Pojo.AccountPojo;
import Pojo.LoginPojo;
import exception.ApplicationException;

public interface LoginService {
	public LoginPojo createAccount (LoginPojo loginpojo);
	
	
}
