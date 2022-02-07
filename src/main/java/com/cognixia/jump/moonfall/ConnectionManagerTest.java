package com.cognixia.jump.moonfall;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionManagerTest {
	
	@Test
	void MakeConnectionTest() {
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
