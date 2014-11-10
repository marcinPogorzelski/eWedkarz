package com.pogorzelskimarcin;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomAdapter extends BaseAdapter {
	
	private Context context;
	private List<PolowP2> listaPolowow;
	
	

	public CustomAdapter(Context context, List<PolowP2> listaPolowow) {
		super();
		this.context = context;
		this.listaPolowow = listaPolowow;
	}

	@Override
	public int getCount() {
		return listaPolowow.size();
	}

	@Override
	public Object getItem(int position) {
		return listaPolowow.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
