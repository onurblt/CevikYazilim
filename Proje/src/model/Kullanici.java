package model;
import java.sql.*;

public class Kullanici {
	Connection c = null;
	public int id;
	public String ad;
	public String email;
	public String sifre;
	 
	public  int yetki=Yetki.YETKISIZ;

}
