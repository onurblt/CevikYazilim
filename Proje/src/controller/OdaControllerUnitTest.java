package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Oda;
import model.Otel;

public class OdaControllerUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	   public void testOdaSil(){
		 	assertEquals(false, OdaController.silMock(null));
		   Otel otel=new Otel();
		   otel.ad="Resort";
		   Oda oda1=new Oda(otel);
		   int simdikiOdalar=otel.odalar.size();
		   assertEquals(true, OdaController.silMock(oda1));
		   assertEquals(simdikiOdalar-1,otel.odalar.size());
		   
		   
		   Otel otel2=null;
		   Oda oda2=new Oda(otel2);
		   assertEquals(false,OdaController.silMock(oda2));
		   
		   
	   }
}
