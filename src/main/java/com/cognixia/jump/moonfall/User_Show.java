package com.cognixia.jump.moonfall;

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
	
	
}
