package com.irelandken.message;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

/**
 *  下面的实验表明, 只有创建view的线程才能操作那个view, 其它线程不能操作view
 *  即: 只要是子就无法更新main线程的组件, 那么现在只能采用线程间利用消息通信的方式
 *  在子线程之中返回要操作的消息, 然后在线程中利用Handler来处理这些消息,
 *  从而实现线程的操作
 * @author kenzfliang
 */
public class MainActivity extends Activity {

	private TextView info = null;
	private static int count = 0;  //表示更新后的记录
	
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
				
				//这里会报错:android.view.ViewRootImpl$CalledFromWrongThreadException: 
				//Only the original thread that created a view hierarchy can touch its views.
				//只有创建view的线程才能操作那个view, 其它线程不能操作view 
				//(Thread[Timer-0,5,main] 不能操作由main线程创建的 view) 
				MainActivity.this.info.setText("MLDN - " + count++);
			}
			
		}, 0,1000);
	}
}
