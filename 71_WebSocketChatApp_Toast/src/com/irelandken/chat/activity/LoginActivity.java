package com.irelandken.chat.activity;

import com.irelandken.chat.ApplicationContext;
import com.irelandken.chat.R;
import com.irelandken.chat.message.Message;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

/**
 * @See http://blog.csdn.net/manoel/article/details/7582454
 * @author kenzfliang
 */
public class LoginActivity extends Activity {

	private EditText usernameEdit;
	
	//Toast Wigit可以重用
	private Toast toast;
	
	public static final int LOGIN_RESULT = 1;
	
	private Handler messageHandler;

	/**
	 * @return 当前Activity关于main thread的Handler
	 */
	public Handler getMessageHandler() {
		return messageHandler;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_login);
		
		ApplicationContext.LOGIN_ACTIVITY = this;
		
		usernameEdit = (EditText) super.findViewById(R.id.usernameEdit);
		
		this.toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
		
		//登录
		Button loginBtn = (Button) super.findViewById(R.id.loginBtn);
		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = usernameEdit.getText().toString();
				
				if(username.length() == 0) {
					return;
				}
				
				boolean connected = ApplicationContext.webSocketConnectSync();
				
				if(! connected) {
					LoginActivity.this.toast.setText("网络连接失败，请检查你的网络设置");
					LoginActivity.this.toast.show();
					return;
				}
				
				Message message = new Message();
				message.setType(Message.TYPE_LOGIN);
				//用户名
				message.setContent(username);
					
				ApplicationContext.sendMessage(message);
			}
		});
		
		//主线程的Looper: 消息循环
		Looper uiLooper = Looper.myLooper();
		
		/**
		 * 从Looper的MessageQueue取出信息，然后显示信息的Handler
		 */
		messageHandler = new Handler(uiLooper, new Handler.Callback() {
			
			@Override
			public boolean handleMessage(android.os.Message msg) {
				System.out.println("[LOGIN RESULT]:" + msg.obj);

				Message message = (Message) msg.obj;
				
				if(message.getContent().equals("200")) {
					//登录成功
					Intent intent = new Intent();
					
					//设置打开OtherActivity
					intent.setClass(LoginActivity.this, ImMessageListActivity.class);
					
					//传送数据
					//intent.putExtra("username", "xxx");
					
					LoginActivity.this.startActivity(intent);
				}
				
				return true;
			}
		});

		
	}
}
