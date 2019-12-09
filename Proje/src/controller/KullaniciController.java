package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Kullanici;
import model.Yetki;

public class KullaniciController {

	public static ArrayList<Kullanici> Yenile(int yetki ) {
		ArrayList<Kullanici> liste = new ArrayList<Kullanici>();
		//liste.clear();

		ResultSet rs = null;

		try {
			if(yetki==Yetki.HEPSI)
			{
				rs=DB.Calistir("SELECT * FROM kullanicilar ");
			}	
			else if(yetki==Yetki.GECERLI)
			{
				rs=DB.Calistir("SELECT * FROM kullanicilar WHERE statu =1");
			}
			else
			{
				rs=DB.Calistir("SELECT * FROM kullanicilar WHERE yetki = " + Integer.toString(yetki)+ " AND statu =1 ");
			}
			
			while (rs.next()) {
				Kullanici kullanici = new Kullanici();


				kullanici.id = rs.getInt(1);
				kullanici.ad = rs.getString(2);
				kullanici.email = rs.getString(3);
				kullanici.sifre = rs.getString(4);
				kullanici.yetki= rs.getInt(5);
				liste.add(kullanici);
				
			}
			
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			return liste;
		}
		DB.Temizle(rs);
		return liste;
	}

	public static boolean Ekle(Kullanici kullanici) {


		ResultSet rs = null;

		try {
			rs = DB.Calistir("INSERT INTO kullanicilar (ad, email,sifre, yetki) "
					+ "VALUES ('" + kullanici.ad + "', '" + kullanici.email + "','"
					+ kullanici.sifre + "'," + 
					Integer.toString(kullanici.yetki) +
					 ");");
			
			DB.Temizle(rs);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		//Application.BilgiKutusu("ISLEM BASARILI", "Ekleme islemi basariyla gerceklestirildi!");
		return true;
	}
	public static boolean EkleMock(Kullanici kullanici) {
		if(kullanici==null)
		{
			return false;
		}
		return true;
	}
	public static boolean Sil(Kullanici kullanici) {


		boolean varMi = false;

		try {
			
			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT ad FROM kullanicilar WHERE ad = \'" + kullanici.ad +"\'";
		
			ResultSet rs = DB.Calistir(SQL);

			if (rs.next()) {
				varMi = true;
			}
			DB.Temizle(rs);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		
		if (varMi == false) {
			//Application.BilgiKutusu("HATA!", "Bu bilgilerde kayit yoktur!");
			return false;
		}

		try {
			
			// Create and execute an SQL statement that returns some data.
			String SQL = " DELETE FROM  kullanicilar WHERE ad=\'" + kullanici.ad
					+ "\';";
			ResultSet rs = DB.Calistir(SQL);
			
			DB.Temizle(rs);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		
		//Application.BilgiKutusu("ISLEM BASARILI", "Silme islemi basariyla gerceklestirildi!");
		return true;

	}
	public static boolean SilMock(Kullanici kullanici) {
		if(kullanici==null)
		{
			return false;
		}
		return true;
	}

	public static Kullanici get(int id) 
	{
		Kullanici kullanici = null;
	
		ResultSet rs = null;

		try {
		
			String SQL = "SELECT * FROM kullanicilar WHERE id="+Integer.toString(id)+";";
			
			rs = DB.Calistir(SQL);

			if (rs.next()) {
				kullanici = new Kullanici();

				kullanici.id = rs.getInt(1);
				kullanici.ad = rs.getString(2);
				kullanici.email = rs.getString(3);
				kullanici.sifre = rs.getString(4);
				kullanici.yetki = rs.getInt(5);
				
			}
			DB.Temizle(rs);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			return kullanici;
		}

		
		return kullanici;
	}
	public static Kullanici getMock(int id) {
	
		Kullanici kullanici = new Kullanici();
		kullanici.id=1;
		kullanici.ad="Elon Musk";
		kullanici.yetki=Yetki.SISTEM_YONETICISI;
		
		return kullanici;
	}
	public static Kullanici get(String ad) 
	{
		Kullanici kullanici = null;
	
		ResultSet rs = null;

		try {
		
			String SQL = "SELECT * FROM kullanicilar WHERE ad=\'"+ad+"\';";
			
			rs = DB.Calistir(SQL);

			if (rs.next()) {
				kullanici = new Kullanici();

				kullanici.id = rs.getInt(1);
				kullanici.ad = rs.getString(2);
				kullanici.email = rs.getString(3);
				kullanici.sifre = rs.getString(4);
				kullanici.yetki = rs.getInt(5);
				
			}
			DB.Temizle(rs);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			return kullanici;
		}

		
		return kullanici;
	}
	public static Kullanici getMock(String ad) {
		if(ad.equals(""))
		{
			return null;
		}
		Kullanici kullanici = new Kullanici();
		kullanici.id=1;
		kullanici.ad="Elon Musk";
		kullanici.yetki=Yetki.SISTEM_YONETICISI;
		
		return kullanici;
	}
	
	
	
}
