package com.pogorzelskimarcin;


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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DodajPolowActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dodaj_polow);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodaj_polow, menu);
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
			// TODO Auto-generated method stub
			super.onAttach(activity);
			myContext = activity;
		}

		

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_dodaj_polow,
					container, false);
			Button button = (Button) rootView.findViewById(R.id.btnDodaj);
			button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.i("onClick", "Dodajê wpis...");
					DodajPolowDoListy(myContext);
					Log.i("onClick", "Dodano wpis.");
				}
			});

			return rootView;
		}
		public void DodajPolowDoListy(Context context)
		{
			MojaBazaClass mbc = new MojaBazaClass(context);
			Toast.makeText(context, mbc.getReadableDatabase().toString(), Toast.LENGTH_LONG).show();
			mbc.dodajWpis(
					"Szczupak"
					, 45.0
					, 15.0
					, 22.0
					, 55.0
					);
		}
	}
	
	
}
