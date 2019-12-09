package controller;

import java.io.File;
import java.io.IOException;
import java.sql.*;



public class DB {

	public static Connection con = null;
	public static Statement stmt;
	public static PreparedStatement ps=null;
	
	private static boolean cleaned=true;
	

	public static ResultSet Calistir(String SQL) {

		if(SQL==null)
		{
			return null;
		}
		if(SQL.equals(""))
		{
			return null;
		}
		if(cleaned==false)
		{
			Temizle(null);
		}
		ResultSet rs=null;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:"+DB.dbAdi);

			// Create and execute an SQL statement that returns some data.
			stmt = con.createStatement();
			if(SQL.contains("DELETE")||SQL.contains("INSERT"))
			{

				stmt.execute(SQL);
			}
			else
			{
				rs = stmt.executeQuery(SQL);
			
			}
			
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		cleaned=false;
		return rs;

	}



	public static ResultSet CalistirMock(String SQL) {
		ResultSet result=null;
		cleaned=false;

		if(SQL==null)
		{
			return null;
		}
		if(SQL.equals(""))
		{
			return null;
		}
		
		return result;
	
	}
	public static void Temizle(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (Exception e) {
			}
		cleaned=true;
	}

	public static boolean isCleaned() {
		return cleaned;
	
	}


	public static void TemizleMock(ResultSet rs) {
		
		cleaned=true;
	}

	public static String dbAdi = "veritabani.db";
}
