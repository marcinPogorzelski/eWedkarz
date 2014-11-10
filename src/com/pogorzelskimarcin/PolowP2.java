package com.pogorzelskimarcin;


public class PolowP2 {
	int id;
	String ryba;
	double waga;
	double dlugosc;
	double latt;
	double longitude;
	
	public PolowP2(int id, String ryba, double waga, double dlugosc, double latt,
			double longitude) {
		super();
		this.id = id;
		this.ryba = ryba;
		this.waga = waga;
		this.dlugosc = dlugosc;
		this.latt = latt;
		this.longitude = longitude;
	}

	public PolowP2() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRyba() {
		return ryba;
	}

	public void setRyba(String ryba) {
		this.ryba = ryba;
	}

	public double getWaga() {
		return waga;
	}

	public void setWaga(double waga) {
		this.waga = waga;
	}

	public double getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(double dlugosc) {
		this.dlugosc = dlugosc;
	}

	public double getLatt() {
		return latt;
	}

	public void setLatt(double latt) {
		this.latt = latt;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "PolowP2 [id=" + id + ", ryba=" + ryba + ", waga=" + waga
				+ ", dlugosc=" + dlugosc + ", latt=" + latt + ", longitude="
				+ longitude + "]";
	}

	
	
	
	
}
