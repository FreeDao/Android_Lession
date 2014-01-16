package com.irelandken.service;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	private Button startBtn;
	private Button stopBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.startBtn = (Button) super.findViewById(R.id.startBtn);
		this.stopBtn  = (Button) super.findViewById(R.id.stopBtn);
		
		startBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//¿˚”√Intent∆Ù∂ØService
				MainActivity.this.startService(new Intent(MainActivity.this, MyService.class));
			}
		});
		
		stopBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Õ£÷πService
				MainActivity.this.stopService(new Intent(MainActivity.this, MyService.class));
			}
		});
		
	}

}
