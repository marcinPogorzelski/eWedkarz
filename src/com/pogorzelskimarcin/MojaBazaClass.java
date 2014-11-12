package com.pogorzelskimarcin;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MojaBazaClass extends SQLiteOpenHelper{

	private static final String NAZWA_PLIKU_BAZY = "etest.db";
	private static final String NAZWA_TABELI = "Polow";
	private static final String NAZWA_ID = "_id";
	private static final String NAZWA_RYBA = "nazwa_ryba";
	private static final String NAZWA_WAGA = "waga";
	private static final String NAZWA_DLUGOSC= "dlugosc";
	private static final String NAZWA_LATT= "latt";
	private static final String NAZWA_LONGITUDE= "longitude";
	private static final String[] COLUMNS = {NAZWA_ID, NAZWA_RYBA, NAZWA_WAGA, NAZWA_DLUGOSC, NAZWA_LATT
		, NAZWA_LONGITUDE};
	private static final String TWORZENIE_TABELI_POLOW_SQL = "create table Polow("+
			"id integer primary key autoincrement, "+
			"ryba_nazwa text, "+
			"waga double, "+
			"dlugosc double, "+
			"latt double, "+
			"longitude double);";

	public MojaBazaClass(Context context) {
		super(context,NAZWA_PLIKU_BAZY , null, 1);
		Log.i("BAZA DANYCH","Uzyto konstruktora MojaBazaClass");
		// TODO Auto-generated constructor stub	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//dodać kod konstruowania tabel
		String query = ("create table "+ NAZWA_TABELI +"("+
				NAZWA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				NAZWA_RYBA+" TEXT NOT NULL,"+
				NAZWA_WAGA+" DOUBLE,"+
				NAZWA_DLUGOSC+" DOUBLE,"+
				NAZWA_LATT+" DOUBLE,"+
				NAZWA_LONGITUDE+" DOUBLE);");
		Log.i("BAZA DANYCH","Dodaję nową bazę: "+query);	
		db.execSQL(
				"create table "+ NAZWA_TABELI +"("+
				NAZWA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				NAZWA_RYBA+" TEXT NOT NULL,"+
				NAZWA_WAGA+" DOUBLE,"+
				NAZWA_DLUGOSC+" DOUBLE,"+
				NAZWA_LATT+" DOUBLE,"+
				NAZWA_LONGITUDE+" DOUBLE);"
				);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.i("UPGRADE BAZY","Baza zostala zupgrade`owana");
		
	}
	
	public void dodajWpis(
			String ryba
			, double waga
			, double dlugosc
			, double latt
			, double longitude
			)
	{
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(NAZWA_RYBA,ryba);
		contentValues.put(NAZWA_WAGA, waga);
		contentValues.put(NAZWA_DLUGOSC, dlugosc);
		contentValues.put(NAZWA_LATT, latt);
		contentValues.put(NAZWA_LONGITUDE, longitude);
		db.insertOrThrow(NAZWA_TABELI, null, contentValues);
		Log.i("BAZA DANYCH","Dodałem wpis do bazy");
	}
	
	public PolowP2 getSingleWpis(int id)
	{
		SQLiteDatabase db = getReadableDatabase();
		
		Cursor cursor = db.query(NAZWA_TABELI, COLUMNS, "_id=?"
				, new String[]{String.valueOf(id)}, null, null, null, null);
		if(cursor!=null)
			cursor.moveToFirst();
		
		PolowP2 p2 = new PolowP2();
		p2.setId(Integer.parseInt(cursor.getString(0)));
		p2.setRyba(cursor.getString(1));
		p2.setWaga(Double.parseDouble(cursor.getString(2)));
		p2.setDlugosc(Double.parseDouble(cursor.getString(3)));
		p2.setLatt(Double.parseDouble(cursor.getString(4)));
		p2.setLongitude(Double.parseDouble(cursor.getString(5)));
		
		Log.i("getSingleWpis: "+id,p2.toString());
		return p2;
	}
	
	public ArrayList<PolowP2> getAll()
	{
		ArrayList<PolowP2> lista = new ArrayList<PolowP2>();
		String query = "select * from "+NAZWA_TABELI+";";
		Log.i("LOG","Wywołano: " + query);
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(query, null);
		
		if(c.moveToFirst())
		{
			do
			{
				PolowP2 p2 = new PolowP2();
				p2.setId(c.getInt(c.getColumnIndex(NAZWA_ID)));
				p2.setRyba(c.getString(c.getColumnIndex(NAZWA_RYBA)));
				p2.setWaga(c.getDouble(c.getColumnIndex(NAZWA_WAGA)));
				p2.setDlugosc(c.getDouble(c.getColumnIndex(NAZWA_DLUGOSC)));
				p2.setLatt(c.getDouble(c.getColumnIndex(NAZWA_LATT)));
				p2.setLongitude(c.getDouble(c.getColumnIndex(NAZWA_LONGITUDE)));
				Log.i("getAll: ",p2.toString());
				lista.add(p2);
			}while(c.moveToNext());	
		}
		return lista;
	}

}