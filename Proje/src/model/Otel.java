package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Otel {
	
	
	public  ArrayList<Oda> odalar=null;
	
	public Otel()
	{
	
		odalar =new ArrayList<Oda>();
	
	}
	public String ad="";
	public int id=0;
	public int sorumlu=0;
	public int kapasite=0;
	public int musteriSayisi=0;
	
	

}
