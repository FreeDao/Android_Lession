package com.irelandken.handler;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity {
	
	Button sendMsgButton;
	
	Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sendMsgButton = (Button) findViewById(R.id.startButton);
		
		sendMsgButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						System.out.println("Sending...");
					}
				});
			}
		});
	}
}
