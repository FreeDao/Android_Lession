package com.irelandken.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * �����뷽ʽʵ��UI 
 * @author kenzfliang
 */

public class UICodeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView text = new TextView(this);
		
		text.setText("Hello World @ KEN");
		
		super.setContentView(text);
	}

}
