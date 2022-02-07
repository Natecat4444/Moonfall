package com.cognixia.jump.moonfallTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cognixia.jump.moonfall.ConnectionManager;
import com.cognixia.jump.moonfall.User_Show;

public class User_ShowTest {

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
	public void TestUserID() {
		User_Show test = new User_Show(0, 0);
		test.setUserID(-1);
		assertEquals(test.getUserID(), -1);
	}
	
	@Test
	public void TestShowID() {
		User_Show test = new User_Show(0, 0);
		test.setShowID(-1);
		assertEquals(test.getShowID(),-1);
	}
	
	@Test
	public void TestProgress() {
		User_Show test = new User_Show(0, 0);
		test.setProgress(-1);
		assertEquals(test.getProgress(),-1);
	}

}
