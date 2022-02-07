package com.cognixia.jump.moonfall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_Show {
	int UserID;
	int ShowID;
	int Progress;
	
	public User_Show(int UserID, int ShowID) {
		this.UserID = UserID;
		this.ShowID = ShowID;
		Progress = 0;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getShowID() {
		return ShowID;
	}

	public void setShowID(int showID) {
		ShowID = showID;
	}

	public int getProgress() {
		return Progress;
	}

	public void setProgress(int progress) {
		Progress = progress;
	}
	
	public int insert() {
		PreparedStatement stmt;
		Connection conn = ConnectionManager.getConnection();
		int result = 0;
		try {
			stmt = conn.prepareStatement("Insert into User_Show(UserID, ShowID, Progress) values(?,?,?)");
			stmt.setInt(1, UserID);
			stmt.setInt(2, ShowID);
			stmt.setInt(3, Progress);
			result = stmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int update() {
		int result = 0;
		
		return result;
	}
}
