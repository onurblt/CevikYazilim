package controller;

import java.sql.*;

import model.Kullanici;
import model.Yetki;

public class LoginController {
	
	public static void Giris(String ad,String sifre)
	{
		simdikiKullanici=null;
		System.gc();
		simdikiKullanici=new Kullanici();
		
		simdikiKullanici.yetki=Yetki.YETKISIZ;
		if(ad.equals("") || sifre.equals(""))
		{
			return;
		}
		
		   try {
		  
		   
		      ResultSet rs =DB.Calistir( "SELECT * FROM kullanicilar WHERE ad=\'"+ad+"\' AND sifre=\'"+sifre+"\'"  );
		      
		      if ( rs.next() ) {
		    	  simdikiKullanici.id = rs.getInt(1);
		    	  simdikiKullanici. ad = rs.getString(2);
		    	  simdikiKullanici. email  = rs.getString(3);
		    	  simdikiKullanici.sifre= rs.getString(4);
		    	  simdikiKullanici.yetki= rs.getInt(5);
		      }
		    	  
		      DB.Temizle(rs);
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   
		     // System.exit(0);
		   }
		   System.out.println("Operation done successfully");
		
	
			
	}
	
	public void Cikis()
	{
		
	}
	
	static public Kullanici simdikiKullanici=new Kullanici();
	

}
