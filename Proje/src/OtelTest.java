import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OtelTest {

	//Otel otel;
	@Before
	public void setUp() throws Exception {
		//otel=new Otel();
	}

	@After
	public void tearDown() throws Exception {
	//otel=null;
	//System.gc();
	}

	@Test
	public void testGetHotels() {
		ArrayList<Otel> oteller = Otel.alOteller();
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
		
		
		assertNotEquals( null,Otel.getOtel("Palace"));
		assertEquals( null,Otel.getOtel("Yok"));
		
		
		
	}
	
	@Test
	public void testEkle() {
		Otel otelNull=null;
		assertEquals(false,Otel.otelEkle(otelNull));
		
		Otel otel1=new Otel();
		assertEquals(false,Otel.otelEkle(otel1));
		
		Otel otel2=new Otel();
		otel2.ad="";
		assertEquals(false,Otel.otelEkle(otel2));
		
		Otel otel3=new Otel();
		otel3.kapasite=0;
		assertEquals(false,Otel.otelEkle(otel3));
		
		Otel otel4=new Otel();
		otel4.kapasite=100;
		otel4.musteriSayisi=200;
		assertEquals(false,Otel.otelEkle(otel4));
		
		
		Otel otel5=new Otel();
		otel5.ad="ABC";
		otel5.kapasite=125;
		otel5.musteriSayisi=2;
		

		assertEquals( null,Otel.getOtel("ABC"));
		Otel.otelEkle(otel5);
		assertNotEquals( null,Otel.getOtel("ABC"));
		//Otel.silOtel("Palace");
		
		
		
		
	}
	@Test
	public void testSil() {
		
		assertEquals( null,Otel.getOtel("Yok"));
		assertEquals(true,Otel.silOtel("Yok"));

		assertNotEquals( null,Otel.getOtel("ABC"));
		assertEquals(true,Otel.silOtel("ABC"));
		assertEquals( null,Otel.getOtel("ABC"));
		
	
	
	}

}
