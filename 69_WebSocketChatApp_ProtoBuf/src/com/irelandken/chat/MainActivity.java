package com.irelandken.chat;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.java_websocket.drafts.Draft_17;

import com.irelandken.chat.R;
import com.irelandken.chat.message.Message;
import com.irelandken.chat.message.MessageProtoConverter;
import com.irelandken.chat.websocket.SimpleWebSocketClient;

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
	
	private SimpleWebSocketClient ws;

	private Handler mainThreadMessageReceiveHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);
		
		
		
		//主线程的Looper: 消息循环
		Looper uiLooper = Looper.myLooper();
		
		/**
		 * 从Looper的MessageQueue取出信息，然后显示信息的Handler
		 */
		mainThreadMessageReceiveHandler = new Handler(uiLooper, new Handler.Callback() {
			
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
				message.setFrom("jack");
				message.setTo("tom");
				message.setContent(msg);
				
				if(ws != null) {
					byte[] data = MessageProtoConverter.toByteArray(message);
					System.out.print("Send:");
					for(int i=0 ; i< data.length; i++) {
						System.out.print(data[i]+",");
					}
					System.out.println();
					
					ws.send(data);
					
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
				try {
					MainActivity.this.ws = new SimpleWebSocketClient( new URI( "ws://10.66.117.59/" ), new Draft_17(), 
							                                              MainActivity.this.mainThreadMessageReceiveHandler);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} 
				MainActivity.this.ws.connect();
			}
		});
		
	}
}
