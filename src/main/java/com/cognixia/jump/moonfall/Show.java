package com.cognixia.jump.moonfall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Show {

		private String Title;
		private int ShowID;
		
		public Show() {
			
		}
		
		public Show(String Title) {
			this.Title = Title;
			fetch();
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public int getShowID() {
			return ShowID;
		}

		public void setShowID(int showID) {
			this.ShowID = showID;
		}
		
		public void fetch() {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt;
			ResultSet rs;
			
			System.out.println("Fetch called");
			
			try {
				stmt = conn.prepareStatement("SELECT ShowID from Shows WHERE Title=?");
				stmt.setString(1, Title);
				rs = stmt.executeQuery();
				if(rs.next()) {
					this.ShowID = rs.getInt("ShowID");
					System.out.println(rs.toString());
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		

}
