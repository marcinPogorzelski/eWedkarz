package com.pogorzelskimarcin;

public class Ryba {
private String nazwa;
private double dlugosc;
private double waga;

public Ryba(String _nazwa, double _dlugosc, double _waga)
{
	nazwa=_nazwa;
	dlugosc=_dlugosc;
	waga=_waga;	
}
public String getNazwa(){
	return nazwa;
}

public double getDlugosc(){
	return dlugosc;
}

public double getWaga(){
	return waga;
}

}
