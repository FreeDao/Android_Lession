package com.irelandken.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//取出其它activity传递过来的intent对象
		Intent intent = this.getIntent();
		//取出intent里的数据
		String username = intent.getStringExtra("username");
		
		TextView text = new TextView(this);
		text.setText("Dear "+username+",welcome !");
		
		setContentView(text);
	}
}
