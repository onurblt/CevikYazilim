package controller;

import static org.junit.Assert.*;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBEntegrasyonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalistir() throws SQLException {

		ResultSet rs=DB.Calistir("");
		assertEquals(null,rs);
		DB.Temizle(rs);
		
		rs=DB.Calistir("SELECT * FROM yetkiler");
		assertNotEquals(rs,null);
		assertEquals(true,rs.next());
		assertEquals(rs.getString(2),"Yetkisiz");
		
		assertEquals(true,rs.next());
		assertEquals(rs.getString(2),"Musteri");
		
		assertEquals(true,rs.next());
		assertEquals(rs.getString(2),"OtelSorumlusu");
		
		assertEquals(true,rs.next());
		assertEquals(rs.getString(2),"SistemYoneticisi");
		
		
		DB.Temizle(rs);
	}


	@Test
	public void testTemizle() throws SQLException {
		ResultSet rs=DB.Calistir("SELECT * FROM yetkiler");
		
		assertEquals(DB.isCleaned(),false);
		
		
		DB.Temizle(rs);
		

		assertEquals(DB.isCleaned(),true);
	}
	
	@Test
	public void testIsCleaned() throws SQLException {
		ResultSet rs=DB.Calistir("SELECT * FROM yetkiler");
		
		assertEquals(DB.isCleaned(),false);
		
		
		DB.Temizle(rs);
		

		assertEquals(DB.isCleaned(),true);
	}
}
