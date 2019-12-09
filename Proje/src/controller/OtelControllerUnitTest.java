package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Otel;

public class OtelControllerUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	   @Test
	   public void testEkle(){
		   
		   Otel otel=new Otel();
		   assertEquals(OtelController.ekleMock(otel),true);
		   
		   
	   }
	   

	   @Test
	   public void testGet(){
		   
		   Otel otel=OtelController.getMock("Resort");
		   assertNotEquals(otel,null);
		   assertEquals(otel.ad,"Resort");
		   assertEquals(otel.kapasite,135);
		   
		   
	   }

}
