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
 * MessageQueue���enqueueMessage()������ɽ�msg����ִ��ʱ����ӵ����е�һ��λ�ú�
 * �и��ؼ��Ĵ���ΪnativeWake(mPtr);��һ��, ��һ�лỽ��MessageQueue������Looper���߳�,
 * Ȼ���̲߳ŵ�֪MessageQueue���µ�msg
 * 
 * @author kenzfliang
 *
 */

public class MainActivity extends Activity {

	private ProgressBar progressBar = null;
	
	private TextView info = null;
	
	private static final int PRO_UPDATE = 1;//������what״̬
	
	private Thread updateThread = null;
	
	Handler proUpdateEventHandler = null;

	/**
	 * Params:   ÿ�δ����̨���ȵ�������Integer 
	 * Progress: ���º����ֵInteger
	 * Result:   ��󷵻صĽ�����ص����ַ���
	 * @author kenzfliang
	 */
	private class ChildUpdate extends AsyncTask<Integer, Integer, String> {

		/**
		 * 
		 * [AsyncTask�߳�] doInBackgroundִ����ɺ�, ͨ��Handler��main�̵߳�MessageQueue������Ϣ
		 * 
		 * [Main�߳�] ��MessageQueueȡ����Ϣ, ��ִ��onPostExecute
		 */
		@Override//[��Main�߳���ִ��]
		protected void onPostExecute(String result) {
			MainActivity.this.info.setText(result);
		}

		/**
		 * 
		 * [AsyncTask�߳�]����publishProgress(values), ͨ��Handler��main�̵߳�MessageQueue������Ϣ
		 * 
		 * [Main�߳�] ��MessageQueueȡ����Ϣ, ��ִ��onProgressUpdate
		 * 
		 */
		@Override//[��Main�߳���ִ��]
		protected void onProgressUpdate(Integer... values) { //ÿ�θ���֮�������
			
			MainActivity.this.progressBar.setProgress(values[0]); //���ý���
			MainActivity.this.info.setText("��ǰ�Ľ���ֵ:" + values[0]);
		}

		@Override//[��AsyncTask�߳���ִ��]
		protected String doInBackground(Integer... params) { //ÿ�εĽ��ȴ���, ���Ը���UI���
			
			for(int x = 0; x < 100; x++) {
				
				this.publishProgress(x); //ͨ��Handler��main�̵߳�MessageQueue������Ϣ
				
				try {//�ӳٵ�ʱ��, ���ⲿ����
					Thread.sleep(params[0]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			return "ִ�����"; //return ��, ͨ��Handler��main�̵߳�MessageQueue������Ϣ
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
