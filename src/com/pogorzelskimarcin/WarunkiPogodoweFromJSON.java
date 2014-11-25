package com.pogorzelskimarcin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
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
	TextView textViewTemperatura;
	TextView warunkiPogodowe;
	TextView temperaturaLabel;
	TextView warunkiLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_warunki_pogodowe_from_json);
		temperaturaLabel = (TextView)findViewById(R.id.textViewTemperaturaLabel);
		warunkiLabel = (TextView)findViewById(R.id.textViewWarunkiPogodoweLabel);
		textViewTemperatura = (TextView)findViewById(R.id.textViewTemperatura);
		warunkiPogodowe = (TextView)findViewById(R.id.textViewWarunkiPogodowe);
		new JSONParse().execute();
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
private class JSONParse extends AsyncTask<String, String, JSONObject>
{
		private ProgressDialog progressDialog;
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		progressDialog = new ProgressDialog(WarunkiPogodoweFromJSON.this);
		progressDialog.setMessage("Pobieram dane...");
		progressDialog.setIndeterminate(false);
		progressDialog.setCancelable(true);
		progressDialog.show();
	}

	@Override
	protected void onPostExecute(JSONObject result) {
		progressDialog.dismiss();
		try {
			jsonArray = result.getJSONArray(WEATHER);
			JSONObject obj = jsonArray.getJSONObject(0);
			String warunki = obj.getString(WARUNKI_POGODOWE);
			JSONObject objTemp = result.getJSONObject("main");
			String temp = objTemp.getString(TEMPERATURA);
			//String name = result.getString("name");
			//Log.i("WarunkiPogodoweFromJSON 'name': ", name);
			warunkiPogodowe.setText(warunki);
			textViewTemperatura.setText(temp);
		} catch (JSONException e) {
			e.printStackTrace();
			Log.i("WarunkiPogodoweFromJSON", "B³¹d 'e': "+e.getLocalizedMessage());
		}
	}

	@Override
	protected JSONObject doInBackground(String... params) {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = jsonParser.getJSONFromUrl(url);
		return jsonObject;
	}
	}

}
