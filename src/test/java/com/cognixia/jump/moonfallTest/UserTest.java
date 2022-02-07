package com.cognixia.jump.moonfallTest;




import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.cognixia.jump.moonfall.ConnectionManager;
import com.cognixia.jump.moonfall.User;

public class UserTest {
	
	private static Connection connection= null;
	
	@BeforeAll
	public static void SetUpConnection() {
		connection = ConnectionManager.getConnection();
		assertNotNull(connection);
	}
	
	@AfterAll
	public static void TakeDownConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	@Test
	public void TestFirstName() {
		User testUser = new User();
		String testName = "Carmelo";
		testUser.setFirstName(testName);
		assertTrue(testUser.getFirstName().equals(testName));
	}
	
	@Test
	public void TestLastName() {
		User testUser = new User();
		String testName = "Anthony";
		testUser.setLastName(testName);
		assertTrue(testUser.getLastName().equals(testName));
	}
	
	@Test
	public void TestSetUserID() {
		User testUser = new User();
		int testInt = -1;
		testUser.setId(testInt);
		assertEquals(testInt,testUser.getId());
	}
	
	@Test
	public void TestUsername() {
		User testUser = new User();
		String testUsername = "Carmelo";
		testUser.setUsername(testUsername);
		assertTrue(testUser.getUsername().equals(testUsername));
	}
	
	@Test
	public void TestPassword() {
		User testUser = new User();
		String testPassword = "#StayMe7o";
		testUser.setPassword(testPassword);
		assertTrue(testUser.getPassword().equals(testPassword));
	}
	
}
