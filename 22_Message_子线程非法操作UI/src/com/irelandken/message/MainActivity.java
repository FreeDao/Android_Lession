package com.irelandken.message;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

/**
 *  �����ʵ�����, ֻ�д���view���̲߳��ܲ����Ǹ�view, �����̲߳��ܲ���view
 *  ��: ֻҪ���Ӿ��޷�����main�̵߳����, ��ô����ֻ�ܲ����̼߳�������Ϣͨ�ŵķ�ʽ
 *  �����߳�֮�з���Ҫ��������Ϣ, Ȼ�����߳�������Handler��������Щ��Ϣ,
 *  �Ӷ�ʵ���̵߳Ĳ���
 * @author kenzfliang
 */
public class MainActivity extends Activity {

	private TextView info = null;
	private static int count = 0;  //��ʾ���º�ļ�¼
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		this.info = (TextView) super.findViewById(R.id.info);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("Current Thread: " + Thread.currentThread());//Current Thread: Thread[Timer-0,5,main]
				
				//����ᱨ��:android.view.ViewRootImpl$CalledFromWrongThreadException: 
				//Only the original thread that created a view hierarchy can touch its views.
				//ֻ�д���view���̲߳��ܲ����Ǹ�view, �����̲߳��ܲ���view 
				//(Thread[Timer-0,5,main] ���ܲ�����main�̴߳����� view) 
				MainActivity.this.info.setText("MLDN - " + count++);
			}
			
		}, 0,1000);
	}
}
