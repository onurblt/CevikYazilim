package controller;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Otel;

public class OtelEntegrasyonTest {

	//Otel otel;
	@Before
	public void setUp() throws Exception {
		//otel=new Otel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHotels() {
		ArrayList<Otel> oteller = OtelController.alOteller();
		assertNotEquals(null,oteller);
		for(int i=0;i<oteller.size();i++) {
			assertNotEquals(null,oteller.get(i).ad);
			assertNotEquals(null,oteller.get(i).kapasite);
			assertNotEquals(null,oteller.get(i).id);
			assertNotEquals(null,oteller.get(i).sorumlu);
		}
	}
	@Test
	public void testGet() {
		
		
		assertNotEquals( null,OtelController.get("Palace"));
		assertEquals( null,OtelController.get("Yok"));
		
		
		
	}
	
	@Test
	public void testEkle() {
		Otel otelNull=null;
		assertEquals(false,OtelController.ekle(otelNull));
		
		Otel otel1=new Otel();
		assertEquals(false,OtelController.ekle(otel1));
		
		Otel otel2=new Otel();
		otel2.ad="";
		assertEquals(false,OtelController.ekle(otel2));
		
		Otel otel3=new Otel();
		otel3.kapasite=0;
		assertEquals(false,OtelController.ekle(otel3));
		
		Otel otel4=new Otel();
		otel4.kapasite=100;
		otel4.musteriSayisi=200;
		assertEquals(false,OtelController.ekle(otel4));
		
		
		Otel otel5=new Otel();
		otel5.ad="ABC";
		otel5.kapasite=125;
		otel5.musteriSayisi=2;
		

		assertEquals( null,OtelController.get("ABC"));
		OtelController.ekle(otel5);
		assertNotEquals( null,OtelController.get("ABC"));
		//Otel.silOtel("Palace");
		
		
		
		
	}
	@Test
	public void testSil() {
	
		assertEquals( null,OtelController.get("Yok"));
		assertEquals(true,OtelController.sil("Yok"));

		assertNotEquals( null,OtelController.get("ABC"));
		assertEquals(true,OtelController.sil("ABC"));
		assertEquals( null,OtelController.get("ABC"));
		
	
	
	}
	@Test
	public void testGetOtelOdalar() {
		
		Otel otel=OtelController.get("Palace");
		assertNotEquals( null,otel);
		System.out.println(otel.odalar.size());
		assertEquals(4,otel.odalar.size());
		
		assertEquals(5,otel.odalar.get(0).kapasite);
		assertEquals(true,otel.odalar.get(0).rezervasyon);
		
		assertEquals(3,otel.odalar.get(1).kapasite);
		assertEquals(false,otel.odalar.get(1).rezervasyon);
		
	
	
	}
}
