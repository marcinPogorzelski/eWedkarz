package com.pogorzelskimarcin;

import java.util.Date;


public class Polow {
	private Ryba gatunek;
	private WspolrzedneGeograficzne wspolrzednePolowu;
	private Date czasPolowu;
	//private WarunkiPogodowe warunkiPogodowe;

	public Polow(Ryba _ryba, WspolrzedneGeograficzne _wspolrzedneGeograficzne
			//, WarunkiPogodowe _warunkiPogodowe
			)
	{
		gatunek = _ryba;
		wspolrzednePolowu = _wspolrzedneGeograficzne;
		czasPolowu = new Date();
		//warunkiPogodowe = _warunkiPogodowe;
	}
	
	public Ryba getRyba()
	{
		return gatunek;
	}
	
	public WspolrzedneGeograficzne getWspolrzedne()
	{
		return wspolrzednePolowu;
	}
	
	public Date GetCzasPolowu()
	{
		return czasPolowu;
	}
	
//	public WarunkiPogodowe getWarunkiPogodowe()
//	{
//		return warunkiPogodowe;
//	}

}
