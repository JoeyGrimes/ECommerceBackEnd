	package dao;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

import exception.ApplicationException;

public class DBUtilBank {

		static Connection conn;

		// step 1 - load the driver
		static {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		//make the method static here so I can call the method with the class name
		//as a result I had to make connection conn also static
		// step 2 - establish connection to the database
		static Connection makeConnection(){
			String connectionUrl = "jdbc:postgresql://localhost:5432/bank_management_system";
			String userName = "postgres";
			String password = "sad";
		
			try {
				if (conn == null) { //if connection is not active, make one, otherwise return the existing connection
					conn = DriverManager.getConnection(connectionUrl, userName, password); // this line gets us a new
																							// connection from the database
																							// every time it is called
																							// we only want a connection
																							// only if a previous connection
																							// was not established,
																							// otherwise return the same
																							// connection
																							// best way to implement this is
																							// Singleton design pattern
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return conn;
		}
	}

