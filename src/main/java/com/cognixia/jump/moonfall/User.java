package com.cognixia.jump.moonfall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class User {

	private String username; //defaulted empty
	private String password;
	private String FirstName;
	private String LastName;
	private int id;
	
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
	ResultSet rs;
	
	try {
		pstmt = con.prepareStatement("select FirstName, LastName from User where Email = ? AND UserPassword = ?");
		rs = pstmt.executeQuery();
		if(rs.next()) {
			this.FirstName = rs.getString("FirstName");
			this.LastName = rs.getString("LastName");
			this.id = rs.getInt("UserID");
			return true;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}


	return false;
	
	}

	//Getters and setters
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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

	
	
}
