package com.pogorzelskimarcin;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyCustomAdapterView extends LinearLayout {

	@SuppressWarnings("deprecation")
	public MyCustomAdapterView(Context context, PolowP2 polowP2) {
		super(context);
		setId(polowP2.getId());
		
		setOrientation(LinearLayout.HORIZONTAL);
		setPadding(0, 6, 0, 6);
		
//		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//		params.setMargins(6, 0, 6, 0);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		LinearLayout panLayout = new LinearLayout(context);
		panLayout.setOrientation(LinearLayout.VERTICAL);
		panLayout.setGravity(Gravity.BOTTOM);
		
		TextView textName = new TextView(context);
		textName.setTextSize(16);
		textName.setTypeface(Typeface.DEFAULT_BOLD);
		textName.setText(polowP2.getRyba());
		panLayout.addView(textName);
		
		TextView opisy = new TextView(context);
		opisy.setTextSize(16);
		opisy.setTypeface(Typeface.DEFAULT_BOLD);
		opisy.setText("Waga: "+ polowP2.getWaga()+"; Dlugosc: "+ polowP2.getDlugosc());
		panLayout.addView(opisy);
		
		addView(panLayout, params);		
	}

}
