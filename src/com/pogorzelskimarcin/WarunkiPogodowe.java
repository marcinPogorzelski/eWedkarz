package com.pogorzelskimarcin;

public class WarunkiPogodowe {
	private String zachmurzenie;
	private int cisnienie;
	private int sumaOpadow;
	private int temperatura;
	
	public WarunkiPogodowe(String _zachmurzenie, int _cisnienie, int _sumaOpadow, int _temperatura)
	{
		zachmurzenie=_zachmurzenie;
		cisnienie=_cisnienie;
		sumaOpadow=_sumaOpadow;
		temperatura=_temperatura;
	}

	public String getZachmurzenie()
	{
		return zachmurzenie;
	}
	
	public int getCisnienie()
	{
		return cisnienie;
	}
	
	public int getSumaOpadow()
	{
		return sumaOpadow;
	}
	
	public int getTemperatura()
	{
		return temperatura;
	}
}
