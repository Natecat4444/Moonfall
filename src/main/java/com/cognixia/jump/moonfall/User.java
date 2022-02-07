package com.cognixia.jump.moonfall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	User()
	{
		username = "user";
		password = "password";
	}
	User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	//return true if user exists in database. 
	public boolean login()
	{
	Connection con = ConnectionManager.getConnection();
	PreparedStatement pstmt;
	
	try {
		pstmt = con.prepareStatement("select * from address where addres_id = ?"); //add sql statement for checkin if user/pass exist
	} catch (SQLException e) {
		e.printStackTrace();
	}
//	rs = stmt.executeQuery("select * from address"); //no need for semicolon


	return false;
	
	}

	//Getters and setters
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	private String username = ""; //defaulted empty
	private String password = ""; //defaulted empty
	
	
}
