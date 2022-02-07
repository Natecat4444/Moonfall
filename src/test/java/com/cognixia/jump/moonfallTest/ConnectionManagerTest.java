package com.cognixia.jump.moonfallTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.cognixia.jump.moonfall.ConnectionManager;

public class ConnectionManagerTest {
	
	private static Connection connection= null;
	
	@Test
	public void MakeConnectionTest() {
		connection = ConnectionManager.getConnection();
		assertNotNull(connection);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
