package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Kullanici;
import model.Yetki;

public class KullaniciControllerUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEkle() {
		Kullanici kullanici=new Kullanici();
		
		assertEquals(KullaniciController.EkleMock(kullanici),true);
		assertEquals(KullaniciController.EkleMock(null),false);
	}

	
	@Test
	public void testSil() {

		Kullanici kullanici=new Kullanici();
		assertEquals(KullaniciController.SilMock(kullanici),true);
		assertEquals(KullaniciController.SilMock(null),false);
	}


	@Test
	public void testGetById() {
		Kullanici kullanici=KullaniciController.getMock(1);
		assertNotEquals(kullanici,null);
		assertEquals(kullanici.ad,"Elon Musk");
		assertEquals(kullanici.id,1);
		assertEquals(kullanici.yetki,Yetki.SISTEM_YONETICISI);
	}
	

	@Test
	public void testGetByName() {
		Kullanici kullanici=KullaniciController.getMock("Elon Musk");
		assertNotEquals(kullanici,null);
		assertEquals(kullanici.ad,"Elon Musk");
		assertEquals(kullanici.id,1);
		assertEquals(kullanici.yetki,Yetki.SISTEM_YONETICISI);
	}
}
