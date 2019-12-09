package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import model.Oda;
import model.Otel;

public class OdaController {


	 public static boolean sil(Oda oda)
	 {
		 if(oda==null)
		 {
			 return false;
		 }
		 Otel otel=oda.otel;
		 if(otel==null)
		 {
			 return false;
		 }
		 
		 
		 DB.Calistir("DELETE FROM odalar WHERE id="+Integer.toString(oda.id));
		 DB.Temizle(null);
			
		 otel.odalar.remove(oda);
		 return true;
		 
	 }
	 public static boolean silMock(Oda oda)
	 {
		 if(oda==null)
		 {
			 return false;
		 }
		 Otel otel=oda.otel;
		 if(otel==null)
		 {
			 return false;
		 }
		 
		 otel.odalar.remove(oda);
		
		 return true;
	 }
}
