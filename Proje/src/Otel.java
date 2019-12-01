import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Otel {
	
	public static ArrayList<Otel> oteller=new ArrayList<Otel>();
	
	public String ad="";
	public int id=0;
	public int sorumlu=0;
	public int kapasite=0;
	public int musteriSayisi=0;
	
	static boolean otelEkle(Otel otel)
	{
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
	static Otel getOtel(String ad_)
	{
		Otel otel=null;
		if(ad_.equals(""))
		{
			return null;
		}
		
		Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM oteller WHERE ad='"+ad_+"'" );
		      
		      if ( rs.next() ) {
		    	  otel=new Otel();
		    	  otel.id = rs.getInt("id");
		    	  otel.ad = rs.getString("ad");
		    	  otel.kapasite  = rs.getInt("kapasite");
		    	  otel.musteriSayisi  = rs.getInt("musteriSayisi");

		      }
		    	  rs.close();
			      stmt.close();
			      c.close();
			      
		      
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     // System.exit(0);

		      return null;
		   }
		   System.out.println("Operation done successfully");
		
		
		return otel;
		
	}
	static ArrayList<Otel> alOteller() {
		Otel otel = null;
		//List<Otel> oteller = new ArrayList<Otel>();
		int i=0;
		Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM oteller");
		      
		      while ( rs.next() ) {
		    	  otel=new Otel();
		    	  otel.id = rs.getInt("id");
		    	  otel.ad = rs.getString("ad");
		    	  otel.kapasite  = rs.getInt("kapasite");
		    	  otel.musteriSayisi  = rs.getInt("musteriSayisi");	
		    	  oteller.add(otel);
		      }
		    	  rs.close();
			      stmt.close();
			      c.close();
			      
		      
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     // System.exit(0);

		      return null;
		   }
		  
		
		return oteller;
	}
	
	
	static boolean silOtel(String ad_)
	{
	     Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	  
	         stmt = c.createStatement();
	         String sql = "DELETE from oteller where ad='"+ad_+"'";
	         stmt.executeUpdate(sql);
	         c.commit();

	       
		      stmt.close();
		      c.close();
	     
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        // System.exit(0);
	         return false;
	      }
	      System.out.println("Operation done successfully");
		
		return true;
	}
	

}
