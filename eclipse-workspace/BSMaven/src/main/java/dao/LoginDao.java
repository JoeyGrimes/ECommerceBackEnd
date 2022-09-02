package dao;

import java.util.List;

import Pojo.LoginPojo;
import exception.ApplicationException;

public interface LoginDao {
	Integer compareCustomerLogin(String username, String password);

	Integer compareEmployeeLogin(String username, String password);

	

	LoginPojo createAccount(LoginPojo loginpojo);

}
