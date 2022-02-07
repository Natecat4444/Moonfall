package com.cognixia.jump.moonfall;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	@BeforeClass
	public static void SetUpConnection() {
		
	}
	
	@AfterClass
	public static void TakeDownConnection() {
		
	}
	
	@Test
	public void EmptyConstructor() {
		User testUser = new User();
		assertTrue(testUser.getUsername().equals("user"));
		assertTrue(testUser.getPassword().equals("password"));
	}
	
	@Test
	public void UsernamePasswordConstructor() {
		String username = "Carmelo";
		String password = "#StayMe7o";
		User testUser = new User(username,password);
		assertTrue(testUser.getUsername().equals(username));
		assertTrue(testUser.getPassword().equals(password));
	}
	
}
