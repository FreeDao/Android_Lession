package com.irelandken.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

/**
 * 编码方式实现UI
 * 
 * 简易计算器
 *  
 * @author kenzfliang
 */
public class UICodeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//---------编码方式实现UI-------------------
		final EditText num1 = new EditText(this);
		
		final EditText num2 = new EditText(this);
		
		//+
		TextView sym_add   = new TextView(this);
		sym_add.setText(" + ");
		
		//=
		TextView sym_equal = new TextView(this);
		sym_equal.setText(" = ");
		
		//sum
		final TextView sum = new TextView(this);
		
		Button btn = new Button(this);
		btn.setText("计算");
		
		
		LinearLayout layout = new LinearLayout(this);
		layout.addView(num1);
		layout.addView(sym_add);
		layout.addView(num2);
		layout.addView(sym_equal);
		layout.addView(sum);
		layout.addView(btn);
		
		//-----------绑定事件---------------
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//取得两个EditText控件的值
				int dig1 = Integer.parseInt(num1.getText().toString());
				int dig2 = Integer.parseInt(num2.getText().toString());
				
				Integer s = dig1 + dig2;
				
				sum.setText(s.toString());
			}
		});
		
		super.setContentView(layout);
	}
}
