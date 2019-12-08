package model;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.LoginController;

public class KullaniciEntegrasyonTest {
	
	//Kullanici kullanici;

	@Before
	public void setUp() throws Exception {
	//	kullanici=new Kullanici();
	}
	

	@After
	public void tearDown() throws Exception {
	//	kullanici=null;
		//System.gc();
	}

	@Test
	public void loginTest() {
		
		LoginController.Giris("", "");
		
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		

		LoginController.Giris("user", "");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		
		LoginController.Giris("", "123123");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		
		LoginController.Giris("musteri1", "sifre");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		
		LoginController.Giris("otel1", "123123");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		
		LoginController.Giris("musteri1", "1234");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.MUSTERI);

		LoginController.Giris("otel1", "1234");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.OTEL_SORUMLUSU);
		

		LoginController.Giris("yonetici1", "1234");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.SISTEM_YONETICISI);
		
	}

}
