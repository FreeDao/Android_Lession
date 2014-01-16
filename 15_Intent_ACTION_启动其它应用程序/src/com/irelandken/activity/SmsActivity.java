package com.irelandken.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class SmsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//---------UI-------------------
		
		TextView label = new TextView(this);
		label.setText("短信内容:");
		
		final EditText edit = new EditText(this);
		
		Button sent_btn = new Button(this);
		sent_btn.setText("发送");
		
		LinearLayout layout = new LinearLayout(this);
		layout.addView(label);
		layout.addView(edit);
		layout.addView(sent_btn);
		
		//-----------绑定事件---------------
		
		sent_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Uri uri = Uri.parse("smsto://15989146997");
				
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
				
				//传送数据
				intent.putExtra("sms_body", edit.getText().toString());
				
				startActivity(intent);
			}
		});
		
		setContentView(layout);
	}
}
