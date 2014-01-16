package com.irelandken.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		System.out.println("MainActivity ---> onCreate()");
		
		super.onCreate(savedInstanceState);
		
		Button btn = new Button(this);
		btn.setText("��¼");
		
		EditText edit = new EditText(this);
		
		LinearLayout layout = new LinearLayout(this);
		layout.addView(edit);
		layout.addView(btn);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent();
				
				//���ô�OtherActivity
				intent.setClass(MainActivity.this, OtherActivity.class);
				
				MainActivity.this.startActivity(intent);
			}
		});
		
		setContentView(layout);
	}

	/**
	 * Called when the activity is becoming visible to the user.
	 * Activity��Ϊ�ɼ���ʱ��, onStart������
	 */
	@Override
	protected void onStart() {
		System.out.println("MainActivity ---> onStart()");
		super.onStart();
	}

	/**
	 * Called when the activity will start interacting with the user.
	 * Activity���û���������ʱ, onResume������
	 */
	@Override 
	protected void onResume() {
		System.out.println("MainActivity ---> onResume()");
		super.onResume();
	}
	
	/**
	 * Another activity comes into the foregrount
	 * ��һ��activity������ǰ̨ʱ, onPause������
	 */
	@Override
	protected void onPause() {
		System.out.println("MainActivity ---> onPause()");
		super.onPause();
	}
	

	/**
	 * Called when the activity is no longer visible to the user
	 * Activity��Ϊ���ɼ���ʱ��, onStop������ 
	 */
	@Override 
	protected void onStop() {
		System.out.println("MainActivity ---> onStop()");
		super.onStop();
	}
	
	/**
	 * User navigates to the activity
	 * �û��л���activityʱ, onRestart������
	 */
	@Override
	protected void onRestart() {
		System.out.println("MainActivity ---> onRestart()");
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		System.out.println("MainActivity ---> onDestroy()");
		super.onDestroy();
	}
}
