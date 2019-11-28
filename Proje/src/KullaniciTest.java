import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KullaniciTest {
	
	Kullanici kullanici;

	@Before
	public void setUp() throws Exception {
		kullanici=new Kullanici();
	}
	

	@After
	public void tearDown() throws Exception {
		kullanici=null;
		System.gc();
	}

	@Test
	public void loginTest() {
		
		Yetki sonuc=kullanici.login("", "");
		assertEquals(sonuc,Yetki.YETKISIZ);
		

		sonuc=kullanici.login("user", "");
		assertEquals(sonuc,Yetki.YETKISIZ);
		
		sonuc=kullanici.login("", "123123");
		assertEquals(sonuc,Yetki.YETKISIZ);
		
		sonuc=kullanici.login("musteri1", "sifre");
		assertEquals(sonuc,Yetki.YETKISIZ);
		
		sonuc=kullanici.login("otel1", "123123");
		assertEquals(sonuc,Yetki.YETKISIZ);
		
		sonuc=kullanici.login("musteri1", "1234");
		assertEquals(sonuc,Yetki.MUSTERI);
		

		sonuc=kullanici.login("otel1", "1234");
		assertEquals(sonuc,Yetki.OTEL_SORUMLUSU);
		

		sonuc=kullanici.login("yonetici1", "1234");
		assertEquals(sonuc,Yetki.SISTEM_YONETICISI);
		
	}

}
