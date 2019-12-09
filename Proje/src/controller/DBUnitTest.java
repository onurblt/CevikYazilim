package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalistir() {

		assertEquals(DB.CalistirMock(null),null);
		assertEquals(DB.CalistirMock(""),null);

		assertEquals(DB.CalistirMock("SELECT * FROM kullanicilar"),null);
	}


	@Test
	public void testTemizle() {
		
		DB.TemizleMock(null);
		assertEquals(true,DB.isCleaned());
	}
	

	@Test
	public void testIsCleaned() {
		DB.CalistirMock(null);
		assertEquals(false,DB.isCleaned());
		

		
		
		DB.TemizleMock(null);
		assertEquals(true,DB.isCleaned());
	}
}
