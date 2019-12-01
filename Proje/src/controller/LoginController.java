package controller;

import java.sql.*;

import model.Kullanici;
import model.Yetki;

public class LoginController {
	
	public static void Giris(String kullaniciAdi,String sifre)
	{
		aktifKullanici=null;
		System.gc();
		aktifKullanici=new Kullanici();
		Yetki yetki=aktifKullanici.login(kullaniciAdi, sifre);
		
			
	}
	
	public void Cikis()
	{
		
	}
	
	static public Kullanici aktifKullanici=new Kullanici();
	

}
