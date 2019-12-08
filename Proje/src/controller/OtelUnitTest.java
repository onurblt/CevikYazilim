package controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;


import model.Otel;

public class OtelUnitTest {

	
	
	
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
