package com.irelandken.chat.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irelandken.chat.ApplicationContext;
import com.irelandken.chat.R;
import com.irelandken.chat.message.Message;
import com.irelandken.chat.ui.ChatMessageListAdapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;

/**
 * @See http://blog.csdn.net/manoel/article/details/7582454
 * @author kenzfliang
 */
public class MainActivity extends Activity {

	private List<Map<String, Object>> messageList;
	
	private ListView messageListView; //定义ListView组件
	
	private ChatMessageListAdapter messageListAdapter;
	
	public static final int MESSAGE_RECEIVED = 1;
	
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
		super.setContentView(R.layout.activity_main);
		
		ApplicationContext.MAIN_ACTIVITY = this;
		
		
		//主线程的Looper: 消息循环
		Looper uiLooper = Looper.myLooper();
		
		/**
		 * 从Looper的MessageQueue取出信息，然后显示信息的Handler
		 */
		messageHandler = new Handler(uiLooper, new Handler.Callback() {
			
			@Override
			public boolean handleMessage(android.os.Message msg) {
				System.out.println("[Showing Msg]:" + msg.obj);
				
				Map<String,Object> map = new HashMap<String,Object>(2);
				map.put("msg", msg.obj);
				map.put("type", ChatMessageListAdapter.TYPE_LEFT_TEXT);
				
				MainActivity.this.messageList.add(map);
				
				//通知ListView, Data已改变, 刷新ListView
				MainActivity.this.messageListAdapter.notifyDataSetChanged();
				
				return true;
			}
		});
		
		//配置ListView
		messageListView = (ListView) super.findViewById(R.id.chatMessageList);
		
		messageList = new ArrayList<Map<String,Object>>();
		
		messageListAdapter = new ChatMessageListAdapter(this, messageList);
		messageListView.setAdapter(messageListAdapter);
		
		Button sendBtn = (Button) super.findViewById(R.id.sendBtn);
		sendBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				EditText msgEdit = (EditText) MainActivity.this.findViewById(R.id.msgEdit);
				
				String msg = msgEdit.getText().toString();
				
				if(msg.length() == 0) {
					return;
				}
				
				Message message = new Message();
				message.setType(Message.TYPE_TEXT);
				message.setTo(ApplicationContext.CURRENT_USER);
				message.setContent(msg);
				
				if(ApplicationContext.WEB_SOCKET_CLIENT != null) {
					
					ApplicationContext.sendMessage(message);
					
					Map<String,Object> map = new HashMap<String,Object>(2);
					map.put("msg", msg);
					map.put("type", ChatMessageListAdapter.TYPE_RIGHT_TEXT);
					
					messageList.add(map);
					
					//通知ListView, Data已改变, 刷新ListView
					messageListAdapter.notifyDataSetChanged();
					
					//清空输入框
					msgEdit.setText("");
				}
			}
		});
		
		Button personInfoBtn = (Button) super.findViewById(R.id.personInfoBtn);
		personInfoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ApplicationContext.webSocketConnect();
			}
		});
		
	}
}
