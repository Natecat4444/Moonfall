package com.cognixia.jump.moonfallTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.cognixia.jump.moonfall.Show;

public class ShowTest {

	@BeforeAll
	public static void SetUpConnection() {
		
	}
	
	@AfterAll
	public static void TakeDownConnection() {
		
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
	
}
