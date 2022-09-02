package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Pojo.AccountPojo;
import Pojo.LoginPojo;
import exception.ApplicationException;

public class LoginDaoJdbcImpl implements LoginDao {

	public Integer compareCustomerLogin(String email, String password) {

		Connection conn = DBUtilBank.makeConnection();
		Statement stmt = null;
		try {

			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String queryEmail = "SELECT id_number, user_email FROM customer_login WHERE user_email =\'" + email
				+ "\' AND password =\'" + password + "\'";

		try {
			ResultSet rs = stmt.executeQuery(queryEmail);
			if (rs.next() == false) {
				return null;

			} else {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Integer compareEmployeeLogin(String email, String password) {

		Connection conn = DBUtilBank.makeConnection();
		Statement stmt = null;
		try {

			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		String queryEmail = "SELECT id_number, email FROM employee_logins2 WHERE email =\'" + email
				+ "\' AND password =\'" + password + "\'";

		try {
			ResultSet rs = stmt.executeQuery(queryEmail);
			if (rs.next() == false) {
				return null;

			} else {

				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public LoginPojo createAccount(LoginPojo loginpojo) {
		Connection conn = DBUtilBank.makeConnection();
		String query = "INSERT INTO customer_login(user_email, first_name, last_name, password) VALUES('"
				+ loginpojo.getUserEmail() + "','" + loginpojo.getFirstName() + "','" + loginpojo.getLastName() + "','"
				+ loginpojo.getPassword() + "') RETURNING id_number";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int idNumber = rs.getInt(1);// if doesnt work try changing this
			loginpojo.setAccountId(idNumber);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in creating New Account");
		}
		String query1 = "INSERT INTO account_details(account_balance, id_number)VALUES(0, (SELECT id_number FROM customer_login WHERE user_email = '"
				+ loginpojo.getUserEmail() + "'))";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in creating New Account");

		}
		return loginpojo;

	}

	
}
