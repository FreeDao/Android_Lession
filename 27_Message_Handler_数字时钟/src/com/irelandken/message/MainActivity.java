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
 * MessageQueue���enqueueMessage()������ɽ�msg����ִ��ʱ����ӵ����е�һ��λ�ú�
 * �и��ؼ��Ĵ���ΪnativeWake(mPtr);��һ��, ��һ�лỽ��MessageQueue������Looper���߳�,
 * Ȼ���̲߳ŵ�֪MessageQueue���µ�msg
 * 
 * @author kenzfliang
 *
 */

public class MainActivity extends Activity {

	private TextView dateTimeText = null;
	
	private static final int DATETIME_UPDATE = 1;//������what״̬
	
	private Thread timerThread = null;
	
	Handler dateTimeUpdateEventHandler = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//---------��������view��Ϊ�˹۲�MAIN�߳��Ƿ���ִ��---
		EditText editText = new EditText(this);
		Button btn = new Button(this);
		
		LinearLayout layout = new LinearLayout(this);
		layout.addView(editText);
		layout.addView(btn);
		//-----------------------------------------------
		
		//���������ʾʱ���view
		this.dateTimeText = new TextView(this);
		
		layout.addView(dateTimeText);
		
		super.setContentView(layout);
		
		
		//MyHandlerʹ��Ĭ�ϵ�Looper����ǰ�̵߳�looper��
		Looper uiLooper = Looper.myLooper();
		
		//dateTime�����¼��Ĵ�����
		dateTimeUpdateEventHandler = new Handler(uiLooper, new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				
				//�յ�ʱ������¼�, �����ʱ��
				Date date = (Date) msg.obj;
				
				dateTimeText.setText(date.toLocaleString());
				
				System.out.println("[DATETIME UPDATE]:" + date.toLocaleString());
				
				return true;
			}
		});
		
		
		//��̨ʱ���߳�
		timerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				
				while(true) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//������Ϣ(��ӳ���ȡ��Ϣ(���ⴴ��))
					Message msg = Message.obtain(dateTimeUpdateEventHandler, DATETIME_UPDATE,1,1, new Date());
					
					//��msg�Ž�Handler�е�Looper�е���Ϣ����, ������Looper���ڵ��߳�
					dateTimeUpdateEventHandler.sendMessage(msg); 
				}
			}
		});
		timerThread.start();
	}
}
