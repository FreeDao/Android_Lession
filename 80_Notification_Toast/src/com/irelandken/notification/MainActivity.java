package com.irelandken.notification;

import com.irelandken.notification.R;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

/**
 * @See http://blog.csdn.net/manoel/article/details/7578996
 * @author kenzfliang
 */

public class MainActivity extends Activity {

	//Toast Wigit可以重用
	private Toast toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		this.toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);

		
		Button btn = (Button) super.findViewById(R.id.toastBtn);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				toast.setText("LONG TOAST");
				toast.setDuration(Toast.LENGTH_LONG);
				toast.show();
			}
		});
		
		Button btn2 = (Button) super.findViewById(R.id.toastBtn2);
		
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				toast.setText("SHORT TOAST");
				toast.setDuration(Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}
}
