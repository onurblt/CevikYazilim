package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Kullanici;
import model.Rezervasyon;

public class RezervasyonControllerUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEkle() {
		Rezervasyon rezervasyon=null;
		assertEquals(false,RezervasyonController.EkleMock(rezervasyon));
		

		Rezervasyon rezervasyon2=new Rezervasyon();
		rezervasyon2.sahip=null;
		assertEquals(false,RezervasyonController.EkleMock(rezervasyon2));
		
		Rezervasyon rezervasyon3=new Rezervasyon();
		rezervasyon3.sahip=new Kullanici();
		rezervasyon3.sahip.id=1;
		assertEquals(true,RezervasyonController.EkleMock(rezervasyon3));
		
	}
	
	@Test
	public void testSil() {
		Rezervasyon rezervasyon=null;
		assertEquals(false,RezervasyonController.SilMock(rezervasyon));
		

		rezervasyon=new Rezervasyon();
		assertEquals(true,RezervasyonController.SilMock(rezervasyon));
		
		
	}
	
	@Test
	public void testGet() {
		Rezervasyon rezervasyon=RezervasyonController.getMock(1);
		assertEquals(rezervasyon.id,1);
		assertEquals(rezervasyon.sahip.id,2);
		

	}

}
