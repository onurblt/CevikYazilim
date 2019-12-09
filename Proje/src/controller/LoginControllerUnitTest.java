package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Yetki;

public class LoginControllerUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGiris() {
		LoginController.GirisMock("", "");
		
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		

		LoginController.GirisMock("user", "");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		
		LoginController.GirisMock("", "123123");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.YETKISIZ);
		
		
		LoginController.GirisMock("Bill Gates", "1234");
		assertEquals(LoginController.simdikiKullanici.yetki,Yetki.OTEL_SORUMLUSU);

	}

}
