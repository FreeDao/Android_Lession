package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final TextView txt = (TextView) super.findViewById(R.id.textView1);
        
        Button btn1 = (Button) super.findViewById(R.id.button1);
        
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("on click:" + v );
				txt.setText("ABC");
				
				((Button)v).setText("ABC");
			}
		});
        
        
    }
}
