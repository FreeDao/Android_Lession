package com.irelandken.message;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
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

	private ProgressBar progressBar = null;
	
	private TextView info = null;
	
	private static final int PRO_UPDATE = 1;//操作的what状态
	
	private Thread updateThread = null;
	
	Handler proUpdateEventHandler = null;

	/**
	 * Params:   每次处理后台进度的类型是Integer 
	 * Progress: 更新后的数值Integer
	 * Result:   最后返回的结果返回的是字符串
	 * @author kenzfliang
	 */
	private class ChildUpdate extends AsyncTask<Integer, Integer, String> {

		/**
		 * 
		 * [AsyncTask线程] doInBackground执行完成后, 通过Handler给main线程的MessageQueue发送消息
		 * 
		 * [Main线程] 从MessageQueue取出消息, 并执行onPostExecute
		 */
		@Override//[在Main线程中执行]
		protected void onPostExecute(String result) {
			MainActivity.this.info.setText(result);
		}

		/**
		 * 
		 * [AsyncTask线程]调用publishProgress(values), 通过Handler给main线程的MessageQueue发送消息
		 * 
		 * [Main线程] 从MessageQueue取出消息, 并执行onProgressUpdate
		 * 
		 */
		@Override//[在Main线程中执行]
		protected void onProgressUpdate(Integer... values) { //每次更新之后的内容
			
			MainActivity.this.progressBar.setProgress(values[0]); //设置进度
			MainActivity.this.info.setText("当前的进度值:" + values[0]);
		}

		@Override//[在AsyncTask线程中执行]
		protected String doInBackground(Integer... params) { //每次的进度处理, 可以更新UI组件
			
			for(int x = 0; x < 100; x++) {
				
				this.publishProgress(x); //通过Handler给main线程的MessageQueue发送消息
				
				try {//延迟的时间, 由外部决定
					Thread.sleep(params[0]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			return "执行完毕"; //return 后, 通过Handler给main线程的MessageQueue发送消息
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		final Button startBtn = (Button) this.findViewById(R.id.startButton);

		this.progressBar = (ProgressBar) this.findViewById(R.id.myProgressBar);
		this.info = (TextView) this.findViewById(R.id.info);
		
		startBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ChildUpdate child = new ChildUpdate();
				child.execute(100);
			}
		});
	}
}
