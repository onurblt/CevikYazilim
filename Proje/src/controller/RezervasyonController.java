package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Kullanici;
import model.Rezervasyon;
//import view.Application;

public class RezervasyonController {

	public static ArrayList<Rezervasyon>  Yenile() {
		ArrayList<Rezervasyon> liste = new ArrayList<Rezervasyon>();


		
		try {
			ResultSet rs = DB.Calistir("SELECT * FROM rezervasyonlar");

			while (rs.next()) {
				Rezervasyon rezervasyon = new Rezervasyon();
				
				rezervasyon.id= rs.getInt(1);
				rezervasyon.sahip = new Kullanici();
				rezervasyon.sahip.id=rs.getInt(2);
				liste.add(rezervasyon);
				
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
	
	public static boolean Ekle(Rezervasyon rezervasyon) {
		if(rezervasyon==null)
		{
			return false;
		}
		if(rezervasyon.sahip==null)
		{
			return false;
		}
		DB.Calistir("INSERT INTO rezervasyonlar(ownerId) VALUES ("+Integer.toString(rezervasyon.sahip.id)+")");
		DB.Temizle(null);
	
		return true;
	}

	public static boolean EkleMock(Rezervasyon rezervasyon) {

		if(rezervasyon==null)
		{
			return false;
		}
		if(rezervasyon.sahip==null)
		{
			return false;
		}
	
		return true;
	}

	public static boolean Sil(Rezervasyon rezervasyon) {
		if(rezervasyon==null)
		{
			return false;
		}
		DB.Calistir("DELETE FROM rezervasyonlar WHERE id= "+Integer.toString(rezervasyon.id));
		DB.Temizle(null);
	
		return true;

	}
	public static boolean SilMock(Rezervasyon rezervasyon) {

		if(rezervasyon==null)
		{
			return false;
		}
	
		return true;
	}
	
	public static Rezervasyon get(int id) {
		Rezervasyon rezervasyon=null;
		
		ResultSet rs=DB.Calistir("SELECT * FROM rezervasyonlar WHERE id= "+Integer.toString(id));
		try {
			if(rs.next())
			{
				rezervasyon=new Rezervasyon();
				rezervasyon.id=id;
				rezervasyon.sahip=new Kullanici();
				rezervasyon.sahip.id=rs.getInt(2);
			}
		} catch (SQLException e) {

			DB.Temizle(rs);
			e.printStackTrace();
			return null;
		}
		DB.Temizle(rs);
	
		return rezervasyon;
	}
	public static Rezervasyon getMock(int id) {
		Rezervasyon rezervasyon=new Rezervasyon();
		rezervasyon.id=1;
		rezervasyon.sahip = new Kullanici();
		rezervasyon.sahip.id=2;
		return rezervasyon;
	}
}
