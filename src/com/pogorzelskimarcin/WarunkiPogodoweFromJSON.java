package com.pogorzelskimarcin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class WarunkiPogodoweFromJSON extends Activity {
	private static final String WEATHER = "weather";
	private static final String TEMPERATURA = "temp";
	private static final String WARUNKI_POGODOWE = "description";
	private static String url = "http://api.openweathermap.org/data/2.5/weather?lat=52.48&lon=22.18&lang=pl&units=metric";
	JSONArray jsonArray = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_warunki_pogodowe_from_json);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = jsonParser.getJSONFromUrl(url);
		try {
			jsonArray = jsonObject.getJSONArray(WEATHER);
			Log.i("JSON", "Pobieram");
			JSONObject object = jsonArray.getJSONObject(0);
			String temperatura = object.getString(TEMPERATURA);
			String warunki = object.getString(WARUNKI_POGODOWE);
			
			final TextView textViewTemperatura = (TextView)findViewById(R.id.textViewTemperatura);
			final TextView textViewWarunki = (TextView)findViewById(R.id.textViewWarunkiPogodowe);
			textViewTemperatura.setText(temperatura);
			textViewWarunki.setText(warunki);
		} catch (JSONException e) {
			Log.e("WarunkiPogodoweFromJSON","B³¹d podczas pobierania obiektu JSON");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.warunki_pogodowe_from_json, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
