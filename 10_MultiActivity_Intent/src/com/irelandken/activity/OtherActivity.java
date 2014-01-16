package com.irelandken.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView text = new TextView(this);
		text.setText("Hello, I'm Other Activity!");
		
		setContentView(text);
	}
}
