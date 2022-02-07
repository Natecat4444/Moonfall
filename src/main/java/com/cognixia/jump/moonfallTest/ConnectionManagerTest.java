package com.cognixia.jump.moonfallTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.cognixia.jump.moonfall.ConnectionManager;

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
