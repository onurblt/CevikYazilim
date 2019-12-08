package model;

public class Yetki {
	
	public static final int YETKISIZ=0;
	public static final int MUSTERI=1;
	public static final int OTEL_SORUMLUSU=2;
	public static final int SISTEM_YONETICISI=3;
	public static final int HEPSI=4;
	public static final int GECERLI=5;
	
	public static String toString(int yetki)
	{
		if(yetki==MUSTERI)
		{
			return "Müþteri";
		}
		else if(yetki==OTEL_SORUMLUSU)
		{
			return "Otel Sorumlusu";
		}
		else if(yetki==SISTEM_YONETICISI)
		{
			return "Sistem Yöneticisi";
		}
		
		return "Yetkisiz";
	}

}
