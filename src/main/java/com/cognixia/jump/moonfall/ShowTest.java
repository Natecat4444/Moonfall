package com.cognixia.jump.moonfall;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShowTest {

	@BeforeClass
	public static void SetUpConnection() {
		
	}
	
	@AfterClass
	public static void TakeDownConnection() {
		
	}
	
	@Test
	public void SetGetTitle() {
		Show testShow = new Show();
		String fakeShow = "Queen of Jordan";
		testShow.setTitle(fakeShow);
		assertTrue(fakeShow.equals(testShow.getTitle()));
	}
	
	
}
