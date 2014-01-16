package com.irelandken.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//---------UI-------------------
		
		TextView label = new TextView(this);
		label.setText("用户名:");
		
		final EditText edit = new EditText(this);
		
		Button login_btn = new Button(this);
		login_btn.setText("登录");
		
		LinearLayout layout = new LinearLayout(this);
		layout.addView(label);
		layout.addView(edit);
		layout.addView(login_btn);
		
		//-----------绑定事件---------------
		
		login_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent();
				
				//设置打开OtherActivity
				intent.setClass(LoginActivity.this, HomeActivity.class);
				
				//传送数据
				intent.putExtra("username", edit.getText().toString());
				
				LoginActivity.this.startActivity(intent);
			}
		});
		
		setContentView(layout);
	}
}
