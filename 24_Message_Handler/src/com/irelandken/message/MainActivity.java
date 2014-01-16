package com.irelandken.message;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

	private TextView info = null;
	private Button btn = null;
	
	private static int count = 0;  //��ʾ���º�ļ�¼
	private static final int SET = 1;//������what״̬
	
	/**
	 * ��Ϣ������
	 */
	private Handler myHandler = new Handler() {
	
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		this.info = (TextView) super.findViewById(R.id.info);
		this.btn  = (Button) super.findViewById(R.id.btn);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//MyHandlerʹ��Ĭ�ϵ�Looper����ǰ�̵߳�looper��
				MyHandler myHandler = new MyHandler();
				
				String data = "KEN 'S MESSAGE";
				
				myHandler.removeMessages(0);//0 ��ʾ���������Ϣ
				
				//������Ϣ(��ӳ���ȡ��Ϣ(���ⴴ��))
				Message msg = Message.obtain(myHandler, SET,1,1,data);
				
				//������Ϣ
				myHandler.sendMessage(msg); 
			}
		});
	}
	
	private class MyHandler extends Handler{

		@Override
	    public void handleMessage(Message msg) {
			switch(msg.what) {
				case SET: 
					MainActivity.this.info.setText(msg.toString());
			}
	    }
	}
}
