package com.comcast.crm.generic.data.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con;
	
	public void getDbConnection(String url, String username, String password) throws Exception {
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		con= DriverManager.getConnection(url, username, password);
	} catch (Exception e) {
	
	}
	}
	
	
	public void getDbConnection() throws Exception {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			con= DriverManager.getConnection("jdbc://mysql://localhost:3306/Emplyoyee5", "root", "root");
		} catch (Exception e) {
		
		}
		}
		
	public void closeDbConnection() throws Exception {
		try {
			con.close();
		} catch (Exception e) {
			
		}
		
	}
	
	
	public ResultSet executeSelectQuery(String query) throws Exception {
		ResultSet result = null;
		try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);
		}catch (Exception e) {
			
		}
		return result;
		
	}
	
	public int executeNonSelectQuery(String query) throws Exception {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
			
		}
		
	return result;
	
	}
}
