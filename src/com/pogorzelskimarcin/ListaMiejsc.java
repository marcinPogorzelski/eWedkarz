package com.pogorzelskimarcin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListaMiejsc extends ActionBarActivity {

	static final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

	private static void populateList() {

		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("pen", "MONT Blanc");
		temp.put("price", "200.00$");
		temp.put("color", "Silver, Grey, Black");
		list.add(temp);
		HashMap<String, String> temp1 = new HashMap<String, String>();
		temp1.put("pen", "Gucci");
		temp1.put("price", "300.00$");
		temp1.put("color", "Gold, Red");
		list.add(temp1);
		HashMap<String, String> temp2 = new HashMap<String, String>();
		temp2.put("pen", "Parker");
		temp2.put("price", "400.00$");
		temp2.put("color", "Gold, Blue");
		list.add(temp2);
		HashMap<String, String> temp3 = new HashMap<String, String>();
		temp3.put("pen", "Sailor");
		temp3.put("price", "500.00$");
		temp3.put("color", "Silver");
		list.add(temp3);
		HashMap<String, String> temp4 = new HashMap<String, String>();
		temp4.put("pen", "Porsche Design");
		temp4.put("price", "600.00$");
		temp4.put("color", "Silver, Grey, Red");
		list.add(temp4);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_miejsc);
		// listView = (ListView)findViewById(R.id.listview5);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_miejsc, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private Context myContext;

		public PlaceholderFragment() {
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			myContext = activity;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.fragment_lista_miejsc,
					container, false);
			ListView lv = (ListView) rootView.findViewById(R.id.listview5);
			SimpleAdapter adapter = new SimpleAdapter(myContext, list,
					R.layout.fragment_lista_miejsc, new String[] { "pen",
							"price", "color" }, new int[] { R.id.text1,
							R.id.text2, R.id.text3 });
			populateList();
			lv.setAdapter(adapter);

			// listView.setAdapter(null);
			// MojaBazaClass mbc = new MojaBazaClass(myContext);
			// ArrayList<PolowP2> poList = mbc.getAll();
			// CustomAdapter customAdapter = new CustomAdapter(myContext,
			// poList);
			Log.i("TEST LISTY", "Wywolano");
			// listView.setAdapter(customAdapter);
			return rootView;
		}
	}

}
