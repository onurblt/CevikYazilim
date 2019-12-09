package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Oda;
import model.Otel;

public class OtelController {
	
	
	public static ArrayList<Otel> oteller=new  ArrayList<Otel>();
	
	public static boolean ekleMock(Otel otel)
	{
		return true;
	}
	
	public static boolean ekle(Otel otel) {
		if(otel==null)
		{
			return false;
		}
		
		if(otel.ad.equals(""))
		{
			return false;
		}
		if(otel.kapasite<=0)
		{
			return false;
		}
		
		if(otel.kapasite<otel.musteriSayisi)
		{
			return false;
		}
		
		  Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO oteller (ad,sorumlu,kapasite,musteriSayisi) " +
	                        "VALUES ('"+otel.ad+"',"+
	        		 Integer.toString(otel.sorumlu)+","+
	        		 Integer.toString(otel.kapasite)+","+
	        		 Integer.toString(otel.musteriSayisi)+")"; 
	         stmt.executeUpdate(sql);
	         
	         
	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         return false;
	         //System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   
		
		return true;
	
		
	}
	

	public static Otel getMock(String ad_)
	{
		Otel otel=new Otel();
		otel.ad="Resort";
		otel.kapasite=135;
		return otel;
	}
	
	public static Otel get(String ad_)
	{
		Otel otel=null;
		if(ad_.equals(""))
		{
			return null;
		}
		
		   try {
	
		      ResultSet rs = DB.Calistir( "SELECT * FROM oteller WHERE ad='"+ad_+"'" );
		      
		      if ( rs.next() ) {
		    	  otel=new Otel();
		    	  otel.id = rs.getInt("id");
		    	  otel.ad = rs.getString("ad");
		    	  otel.kapasite  = rs.getInt("kapasite");
		    	  otel.musteriSayisi  = rs.getInt("musteriSayisi");

		      }
		    	DB.Temizle(rs);
		      
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     // System.exit(0);

		      return null;
		   }
		   if(otel==null)
		   {
			   return null;
		   }
		   
		   otel.odalar.clear();
			   try {
			      ResultSet rs = DB.Calistir( "SELECT odalar.id,odalar.kapasite,odalar.rezervasyon FROM odalar WHERE odalar.otelId="+Integer.toString(otel.id));
			      //
			      
			      while ( rs.next() ) {
			    	  Oda oda=new Oda(otel);
			    	  oda.id = rs.getInt("id");
			    	  oda.kapasite = rs.getInt("kapasite");

			    	  oda.rezervasyon = rs.getBoolean("rezervasyon");
			    	  
			    	  //otel.odalar.add(oda);

			      }
			      DB.Temizle(rs);
			      
			   } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			     return otel;
			   }
		   System.out.println("Operation done successfully");
	
		
		return otel;
		
	}
	
	
	
	public static ArrayList<Otel> alOteller() {
		Otel otel = null;
		   try {
		   
		      ResultSet rs = DB.Calistir( "SELECT * FROM oteller");
		      oteller.clear();
		      while ( rs.next() ) {
		    	  otel=new Otel();
		    	  otel.id = rs.getInt("id");
		    	  otel.ad = rs.getString("ad");
		    	  otel.kapasite  = rs.getInt("kapasite");
		    	  otel.musteriSayisi  = rs.getInt("musteriSayisi");	
		    	  oteller.add(otel);
		      }
		      DB.Temizle(rs);
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     // System.exit(0);

		      return null;
		   }
		  //odalar
		   
		return oteller;
	}

	
	public static boolean sil(String ad_)
	{
	     Connection c = null;
	      Statement stmt = null;
	      
	      try {
	        
	         String sql = "DELETE from oteller where ad='"+ad_+"'";
	         DB.Calistir(sql);
	        DB.Temizle(null);
	     
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        // System.exit(0);
	         return false;
	      }
	      System.out.println("Operation done successfully");
		
		return true;
	}
}
