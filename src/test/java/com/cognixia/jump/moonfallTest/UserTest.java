package com.cognixia.jump.moonfallTest;




import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.cognixia.jump.moonfall.User;

public class UserTest {

	@BeforeAll
	public static void SetUpConnection() {
		
	}
	
	@AfterAll
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
