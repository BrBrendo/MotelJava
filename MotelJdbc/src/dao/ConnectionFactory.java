package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		 try {
		return DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;user=sa;password=1234;"
				
				);
		 } catch (SQLException error) {
	            throw new RuntimeException("Error: " + error);
	        }
	    }
	}

