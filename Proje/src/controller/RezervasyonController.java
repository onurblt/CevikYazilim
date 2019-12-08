package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Kullanici;
import model.Rezervasyon;
import view.Application;

public class RezervasyonController {

	public static ArrayList<Rezervasyon>  Yenile() {
		ArrayList<Rezervasyon> liste = new ArrayList<Rezervasyon>();


		
		try {
			ResultSet rs = DB.Calistir("SELECT * FROM rezervasyonlar");

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				Rezervasyon urun = new Rezervasyon();
				
				urun.id= rs.getInt(1);
				urun.statu = rs.getInt(4);
				liste.add(urun);
				;
			}
			DB.Temizle(rs);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			return liste;
		}
		return liste;
	}
	
	public static boolean Ekle(Rezervasyon urun) {

	
		Application.BilgiKutusu("ISLEM BASARILI", "Ekleme islemi basariyla gerceklestirildi!");
		return true;
	}

	public static boolean Sil(Rezervasyon urun) {
		
		Application.BilgiKutusu("ISLEM BASARILI", "Silme islemi basariyla gerceklestirildi!");
		return true;

	}

	public static ArrayList<Rezervasyon> ara(String ad) {
		ArrayList<Rezervasyon> bulunan=null;
		return bulunan;

	}
	public static Rezervasyon get(int id) {
		Rezervasyon rezervasyon=null;
		
		return rezervasyon;
	}
}
