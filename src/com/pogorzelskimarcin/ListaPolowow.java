package com.pogorzelskimarcin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaPolowow extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_polowow);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_polowow, menu);
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

			Context myContext;
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
			View rootView = inflater.inflate(R.layout.fragment_lista_polowow,
					container, false);	
			MojaBazaClass mbc = new MojaBazaClass(myContext);
			String[]lista = new String[] { "Android", "iPhone", "WindowsMobile",
			        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
			        "Linux", "OS/2" };
			ListView listView = (ListView)rootView.findViewById(R.id.listView1);
			listView.setAdapter(new ArrayAdapter<String>(myContext, R.layout.fragment_lista_polowow, R.id.listView1TextView, lista));
			return rootView;
		}
	}

}
