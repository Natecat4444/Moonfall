package com.cognixia.jump.moonfallTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.cognixia.jump.moonfall.ConnectionManager;
import com.cognixia.jump.moonfall.Show;

public class ShowTest {
	
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
	public void SetGetTitle() {
		Show testShow = new Show();
		String fakeShow = "Queen of Jordan";
		testShow.setTitle(fakeShow);
		assertTrue(fakeShow.equals(testShow.getTitle()));
	}
	
	@Test
	public void TitleConstructor() {
		String fakeShow = "Gold Case";
		Show testShow = new Show(fakeShow);
		assertTrue(fakeShow.equals(testShow.getTitle()));
	}
	
	@Test
	public void TestSetShowID() {
		Show testShow = new Show();
		int testInt = -1;
		testShow.setShowID(testInt);
		assertEquals(testInt,testShow.getShowID());
	}
	
}
