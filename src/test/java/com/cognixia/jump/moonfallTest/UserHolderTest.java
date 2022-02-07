package com.cognixia.jump.moonfallTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cognixia.jump.moonfall.ConnectionManager;
import com.cognixia.jump.moonfall.User;
import com.cognixia.jump.moonfall.UserHolder;

public class UserHolderTest {

	private static Connection connection = null;

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
	public void testHoldUser() {
		String username = "Carmelo";
		String password = "#StayMe7o";
		User testUser = new User(username, password);
		UserHolder.setUser(testUser);
		assertTrue(UserHolder.getUser().equals(testUser));
	}

}
