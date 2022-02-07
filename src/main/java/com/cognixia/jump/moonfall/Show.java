package com.cognixia.jump.moonfall;

public class Show {

		private String Title;
		private static int ShowID;
		
		public Show() {
			
		}
		
		public Show(String Title) {
			this.Title = Title;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public static int getShowID() {
			return ShowID;
		}

		public static void setShowID(int showID) {
			ShowID = showID;
		}
		
		

}
