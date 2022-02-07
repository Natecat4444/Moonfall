package com.cognixia.jump.moonfall;

public class UserHolder {
	private static User user;
	

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		UserHolder.user = user;
	}
	
	

}
