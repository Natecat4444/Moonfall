package com.cognixia.jump.moonfallTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.cognixia.jump.moonfall.ConnectionManager;

public class ConnectionManagerTest {
	
	@Test
	public void MakeConnectionTest() {
		Connection conn;
		conn = ConnectionManager.getConnection();
		assertNotNull(conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
