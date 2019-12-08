package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KullaniciUnitTest {

	Kullanici kullanici=null;
	@Before
	public void setUp() throws Exception {
		kullanici= new Kullanici();
	}

	@After
	public void tearDown() throws Exception {
		kullanici=null;
		System.gc();
		
	}

	@Test
	public void test() {
		
		assertEquals(kullanici.yetki,Yetki.YETKISIZ);
		
		
	}
	@Test
	public void yetkiTest() {
		
		kullanici.yetki=Yetki.YETKISIZ;
		assertEquals(kullanici.yetki,Yetki.YETKISIZ);

		kullanici.yetki=Yetki.MUSTERI;
		assertEquals(kullanici.yetki,Yetki.MUSTERI);

		kullanici.yetki=Yetki.OTEL_SORUMLUSU;
		assertEquals(kullanici.yetki,Yetki.OTEL_SORUMLUSU);
		
		kullanici.yetki=Yetki.SISTEM_YONETICISI;
		assertEquals(kullanici.yetki,Yetki.SISTEM_YONETICISI);
		
		
	}
	

}
