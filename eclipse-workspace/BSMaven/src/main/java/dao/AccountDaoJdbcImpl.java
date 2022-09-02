package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Pojo.AccountPojo;
import Pojo.LoginPojo;
import Pojo.TransactionPojo;
import exception.ApplicationException;

public class AccountDaoJdbcImpl implements AccountDao {
	public List<AccountPojo> listAllAccounts() {
		Connection conn = DBUtilBank.makeConnection();
		List<AccountPojo> allAccounts = new ArrayList<AccountPojo>();

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM account_details ORDER BY id_number";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				AccountPojo accountPojo = new AccountPojo(rs.getInt(1), rs.getInt(2));

				allAccounts.add(accountPojo);

			}
		} catch (SQLException e) {

		}

		return allAccounts;
	}

	public AccountPojo viewAccount(int idNumber) {
		Connection conn = DBUtilBank.makeConnection();

		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM account_details WHERE id_number =\'" + idNumber + "\'";
			ResultSet rs = stmt.executeQuery(query);

			rs.next();

			AccountPojo accountPojo = new AccountPojo(rs.getInt(1), rs.getInt(2));

			return accountPojo;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public void transferMoney() {

	}

	public void depositCash(int depositCash, int UserID) {
		Connection conn = DBUtilBank.makeConnection();
		PreparedStatement stmt;
		try {
			String query ="INSERT INTO transactions (date, transactiontype, changedamount, id_number) VALUES ( now(), 'Received'," + depositCash + "," +  UserID + ")";
			stmt = conn.prepareStatement(query);
			
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		Statement stmt1;
		try {
			stmt1 = conn.createStatement();

			String query = "UPDATE account_details SET account_balance = account_balance + " + depositCash
					+ "WHERE id_number =" + UserID;

			stmt1.executeUpdate(query);
		} catch (SQLException b) {
			System.out.println("Deposit failed");
			b.printStackTrace();

		}
		System.out.println("Money deposited successfully");
		
	}

	public void withdrawCash(int withdraw, int UserID) {
	
		Connection conn = DBUtilBank.makeConnection();
		PreparedStatement stmt;
		try {
			String query ="INSERT INTO transactions (date, transactiontype, changedamount, id_number) VALUES ( now(), 'Withdraw',"  + withdraw + "," +  UserID + ")";
			stmt = conn.prepareStatement(query);
			
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		Statement stmt1;
		try {
			stmt1 = conn.createStatement();

			String query = "UPDATE account_details SET account_balance = account_balance - " + withdraw
					+ "WHERE id_number =" + UserID;

			stmt1.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("withdraw failed");
			e.printStackTrace();

		}
		System.out.println("Money withdrawed successfully");
	}

	public void transferMoney(int amount, int UserID, int otherID) {
		// TODO Auto-generated method stub
		Connection conn = DBUtilBank.makeConnection();
		PreparedStatement stmt;
		try {
			String query ="INSERT INTO transactions (date, transactiontype, changedamount, id_number) VALUES ( now(), 'Sent'," + amount + "," +  UserID + ")";
			stmt = conn.prepareStatement(query);
			
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Statement stmt1;
		try {
			stmt1 = conn.createStatement();
			String query = "UPDATE account_details SET account_balance = account_balance + " + amount
					+ "WHERE id_number =" + otherID;
			stmt1.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Transfer failed");
			e.printStackTrace();

		}
		String query = "UPDATE account_details SET account_balance = account_balance - " + amount + "WHERE id_number ="
				+ UserID;
		Statement stmt2;
		try {
			stmt2 = conn.createStatement();
			stmt2.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Transfer failed");
			e.printStackTrace();
		}
		System.out.println("Transfer Success");
	}

	public List<TransactionPojo> viewTransactions(int userID) {
		List<TransactionPojo>transactionList = new ArrayList<TransactionPojo>();
		Connection conn = DBUtilBank.makeConnection();
		
		String query = 	"SELECT * FROM transactions WHERE id_number =" + userID; 
				Statement stmt3;
				try {
					stmt3 = conn.createStatement();
					ResultSet rs = stmt3.executeQuery(query);
					while (rs.next()) {
					String l = rs.getString(1);
					String t = rs.getString(2);
					int p = rs.getInt(3);
					int f = rs.getInt(4);
					transactionList.add(new TransactionPojo(l, t, p, f));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		return transactionList;
	}
}
