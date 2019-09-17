package com.api.deploy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2jdbcTruncate {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	public void TruncateTable() {

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			stmt = conn.createStatement();
			
			String tuncate = "TRUNCATE TABLE API_MODELH2;";
			String clearAutoIncrement = "ALTER TABLE API_MODELH2 ALTER COLUMN NUM RESTART WITH 1;";
			stmt.executeUpdate(tuncate);
			stmt.executeUpdate(clearAutoIncrement);
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} 
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}
