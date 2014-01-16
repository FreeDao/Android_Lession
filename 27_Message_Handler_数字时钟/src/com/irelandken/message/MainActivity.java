package com.irelandken.message;

import java.util.Date;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

/**
 * 
 * MessageQueue里的enqueueMessage()方法完成将msg根据执行时间添加到队列的一个位置后
 * 有个关键的代码为nativeWake(mPtr);这一行, 这一行会唤醒MessageQueue所属的Looper的线程,
 * 然后线程才得知MessageQueue有新的msg
 * 
 * @author kenzfliang
 *
 */

public class MainActivity extends Activity {

	private TextView dateTimeText = null;
	
	private static final int DATETIME_UPDATE = 1;//操作的what状态
	
	private Thread timerThread = null;
	
	Handler dateTimeUpdateEventHandler = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//---------以下两个view是为了观察MAIN线程是否在执行---
		EditText editText = new EditText(this);
		Button btn = new Button(this);
		
		LinearLayout layout = new LinearLayout(this);
		layout.addView(editText);
		layout.addView(btn);
		//-----------------------------------------------
		
		//这个才是显示时间的view
		this.dateTimeText = new TextView(this);
		
		layout.addView(dateTimeText);
		
		super.setContentView(layout);
		
		
		//MyHandler使用默认的Looper（当前线程的looper）
		Looper uiLooper = Looper.myLooper();
		
		//dateTime更新事件的处理器
		dateTimeUpdateEventHandler = new Handler(uiLooper, new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				
				//收到时间更新事件, 则更新时间
				Date date = (Date) msg.obj;
				
				dateTimeText.setText(date.toLocaleString());
				
				System.out.println("[DATETIME UPDATE]:" + date.toLocaleString());
				
				return true;
			}
		});
		
		
		//后台时钟线程
		timerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				
				while(true) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//创建消息(或从池里取消息(避免创建))
					Message msg = Message.obtain(dateTimeUpdateEventHandler, DATETIME_UPDATE,1,1, new Date());
					
					//将msg放进Handler中的Looper中的消息队列, 并唤醒Looper所在的线程
					dateTimeUpdateEventHandler.sendMessage(msg); 
				}
			}
		});
		timerThread.start();
	}
}
