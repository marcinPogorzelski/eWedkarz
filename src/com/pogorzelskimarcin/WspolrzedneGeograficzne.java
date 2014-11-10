package com.pogorzelskimarcin;

public class WspolrzedneGeograficzne {
	private double dlugoscGeograficzna;
	private double szerokoscGeograficzna;
	
public WspolrzedneGeograficzne(double dlugosc, double szerokosc)
{
	dlugoscGeograficzna = dlugosc;
	szerokoscGeograficzna = szerokosc;
}

public void setDlugoscGeograficzna(double dlugosc){
	dlugoscGeograficzna = dlugosc;
}

public void setSzerokoscGeograficzna (double szerokosc)
{
	szerokoscGeograficzna = szerokosc;
}

public double getSzerokoscGeograficzna()
{
	return szerokoscGeograficzna;
}

public double getDlugoscGeograficzna()
{
	return dlugoscGeograficzna;
}
}
