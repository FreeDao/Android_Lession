package com.irelandken.intent;

import android.net.Uri;
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
		setContentView(R.layout.activity_main);
		
		Button btn = (Button) this.findViewById(R.id.button1);
		
		//-----------绑定事件---------------
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Uri uri = Uri.parse("smsto://15989146997");
				
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
				
				//传送数据
				intent.putExtra("sms_body", "hello");
				
				startActivity(intent);
			}
		});
	}
}
