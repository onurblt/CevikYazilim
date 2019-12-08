package controller;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Kullanici;
import model.Yetki;

public class KullaniciControllerEntegrasyonTest {

	ResultSet rs;
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testEkle() {
		
		Kullanici kullanici=new Kullanici();
		kullanici.ad="Steve Jobs";
		kullanici.sifre="apple";
		kullanici.yetki=Yetki.SISTEM_YONETICISI;
		assertEquals(KullaniciController.Ekle(kullanici),true);
		
		rs=DB.Calistir("DELETE FROM kullanicilar WHERE ad=\'Steve Jobs\'");

		DB.Temizle(rs);
		
	}
	@Test
	public void testSil() {
		
		rs=DB.Calistir("INSERT  INTO kullanicilar (ad, email,sifre, yetki) VALUES (\'Elon Musk\', \'elonmusk@gmail.com\',"+
				"\'spacex\',3);");

		DB.Temizle(rs);
		
		Kullanici kullanici=new Kullanici();
		kullanici.ad="Elon Musk";
		
		assertEquals(true,KullaniciController.Sil(kullanici));
	
		
		rs=DB.Calistir("DELETE FROM kullanicilar WHERE ad=\'Elon Musk\'");

		DB.Temizle(rs);
		
		assertEquals(false,KullaniciController.Sil(kullanici));
		
		
		
	}
	@Test
	public void testGetById() {
		
		
		
	}
	
	@Test
	public void testGetByName() {
		
		
		
	}
}
