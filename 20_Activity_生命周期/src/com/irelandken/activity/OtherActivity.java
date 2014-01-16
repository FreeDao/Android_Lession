package com.irelandken.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		System.out.println("    OtherActivity ---> onCreate()");
		
		super.onCreate(savedInstanceState);
		
		TextView text = new TextView(this);
		text.setText("Hello, I'm Other Activity!");
		
		setContentView(text);
	}
	

	@Override
	protected void onStart() {
		System.out.println("    OtherActivity ---> onStart()");
		super.onStart();
	}

	@Override
	protected void onResume() {
		System.out.println("    OtherActivity ---> onResume()");
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		System.out.println("    OtherActivity ---> onPause()");
		super.onPause();
	}
	

	@Override
	protected void onStop() {
		System.out.println("    OtherActivity ---> onStop()");
		super.onStop();
	}
	
	@Override
	protected void onRestart() {
		System.out.println("    OtherActivity ---> onRestart()");
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		System.out.println("    OtherActivity ---> onDestroy()");
		super.onDestroy();
	}
}
