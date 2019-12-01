package model;
import java.sql.*;

public class Kullanici {
	  Connection c = null;
	int id;
	String ad;
	String email;
	
	 
	protected  Yetki yetki=Yetki.YETKISIZ;
	public Yetki login(String ad,String sifre)
	{
		yetki=Yetki.YETKISIZ;
		if(ad.equals("") || sifre.equals(""))
		{
			return Yetki.YETKISIZ;
		}
		Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM kullanicilar WHERE ad='"+ad+"' AND sifre='"+sifre+"'"  );
		      
		      if ( rs.next() ) {
		        id = rs.getInt("id");
		        ad = rs.getString("ad");
		        email  = rs.getString("email");
		        // String  sifreDB = rs.getString("sifre");
		         int yetkiDB = rs.getInt("yetki");
		         if(yetkiDB==0)
		         {
		        	 yetki=Yetki.YETKISIZ;
		         }
		         else if(yetkiDB==1)
		         {
		        	 yetki=Yetki.MUSTERI;
		         }
		         else if(yetkiDB==2)
		         {
		        	 yetki=Yetki.OTEL_SORUMLUSU;
		         }
		         else if(yetkiDB==3)
		         {
		        	 yetki=Yetki.SISTEM_YONETICISI;
		         }
		         
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return Yetki.YETKISIZ;
		     // System.exit(0);
		   }
		   System.out.println("Operation done successfully");
		
		return yetki;
	}
	public Yetki getYetki()
	{
		return yetki;
	}
	

}
