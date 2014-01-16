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
	
	private static int count = 0;  //表示更新后的记录
	private static final int SET = 1;//操作的what状态
	
	/**
	 * 消息处理器
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
				//MyHandler使用默认的Looper（当前线程的looper）
				MyHandler myHandler = new MyHandler();
				
				String data = "KEN 'S MESSAGE";
				
				myHandler.removeMessages(0);//0 表示清空所有消息
				
				//创建消息(或从池里取消息(避免创建))
				Message msg = Message.obtain(myHandler, SET,1,1,data);
				
				//发送消息
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
