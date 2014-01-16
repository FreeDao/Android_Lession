package com.irelandken.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Button btn = new Button(this);
		btn.setText("µÇÂ¼");
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent();
				
				//ÉèÖÃ´ò¿ªOtherActivity
				intent.setClass(MainActivity.this, OtherActivity.class);
				
				MainActivity.this.startActivity(intent);
			}
		});
		
		setContentView(btn);
	}
}
