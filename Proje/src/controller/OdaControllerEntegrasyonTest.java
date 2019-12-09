package controller;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Oda;
import model.Otel;

public class OdaControllerEntegrasyonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOdaSil() throws SQLException {
		
		DB.Calistir("INSERT INTO oteller (ad,sorumlu,kapasite,musteriSayisi) VALUES (\'Resort\',1,100,0)");
		DB.Temizle(null);
		ResultSet rs=DB.Calistir("SELECT Max(id) FROM odalar");
		int lastOtelId=rs.getInt(1);
		DB.Temizle(rs);
		
		DB.Calistir("INSERT INTO odalar (kapasite,otelId,rezervasyon) VALUES (4,"+Integer.toString(lastOtelId)+",0)");
		DB.Temizle(null);
		
		// rs=DB.Calistir("SELECT Max(id) FROM odalar");
		//int lastOdaId=rs.getInt(1);
		//DB.Temizle(rs);

		Otel otel = new Otel();
		otel.ad = "Resort";
		Oda oda1 = new Oda(otel);
		int simdikiOdalar = otel.odalar.size();
		assertEquals(true, OdaController.sil(oda1));
		assertEquals(simdikiOdalar - 1, otel.odalar.size());

		Otel otel2 = null;
		Oda oda2 = new Oda(otel2);
		assertEquals(false, OdaController.sil(oda2));
		
		DB.Calistir("DELETE FROM oteller WHERE ad=\'Resort\'");
		DB.Temizle(null);
		
		
		

	}

}
