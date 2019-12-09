package controller;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Kullanici;
import model.Rezervasyon;

public class RezervasyonControllerEntegrasyonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testEkle() throws SQLException {
		Rezervasyon rezervasyon=null;
		assertEquals(false,RezervasyonController.Ekle(rezervasyon));
		

		Rezervasyon rezervasyon2=new Rezervasyon();
		rezervasyon2.sahip=null;
		assertEquals(false,RezervasyonController.Ekle(rezervasyon2));
		
		Rezervasyon rezervasyon3=new Rezervasyon();
		rezervasyon3.sahip=new Kullanici();
		rezervasyon3.sahip.id=1;
		assertEquals(true,RezervasyonController.Ekle(rezervasyon3));
		
		ResultSet rs=DB.Calistir("SELECT Max(id) FROM rezervasyonlar");
		int lastRezId=rs.getInt(1);
		DB.Temizle(rs);
		DB.Calistir("DELETE FROM rezervasyonlar WHERE id ="+Integer.toString(lastRezId));
		DB.Temizle(null);
		
	}
	
	@Test
	public void testSil() {
		Rezervasyon rezervasyon=null;
		assertEquals(false,RezervasyonController.Sil(rezervasyon));
		

		rezervasyon=new Rezervasyon();
		assertEquals(true,RezervasyonController.Sil(rezervasyon));
		
		
	}
	
	@Test
	public void testGet() throws SQLException {
		Rezervasyon rezervasyon=new Rezervasyon();
		rezervasyon.sahip=new Kullanici();
		rezervasyon.sahip.id=2;
		assertEquals(true,RezervasyonController.Ekle(rezervasyon));
		
		ResultSet rs=DB.Calistir("SELECT Max(id) FROM rezervasyonlar");
		int lastRezId=rs.getInt(1);
		DB.Temizle(rs);
		
		Rezervasyon rezervasyon2=RezervasyonController.get(lastRezId);
		assertEquals(rezervasyon2.id,lastRezId);
		assertEquals(rezervasyon2.sahip.id,2);
		

		DB.Calistir("DELETE FROM rezervasyonlar WHERE id ="+Integer.toString(lastRezId));
		DB.Temizle(null);

	}
}
