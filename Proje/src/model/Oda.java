package model;

public class Oda {
	
	public Oda(Otel otel_)
	{
		id=0;
		kapasite=0;
		rezervasyon=false;
		otel=otel_;
		if(otel!=null)
		{
			otel.odalar.add(this);
		}
	}
	public int id;
	public int kapasite;
	public boolean rezervasyon;
	public Otel otel;
}
