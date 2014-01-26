package com.irelandken.chat;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.drafts.Draft_17;

import com.irelandken.chat.activity.MessageBoxActivity;
import com.irelandken.chat.activity.LoginActivity;
import com.irelandken.chat.activity.ChatRoomActivity;

import com.irelandken.chat.message.Message;
import com.irelandken.chat.message.MessageProtoConverter;
import com.irelandken.chat.websocket.SimpleWebSocketClient;

/**
 * 全局的Application Context
 *  1:管理所有Activity
 *  2:消息分发
 *  
 * @author kenzfliang
 *
 */
public class ApplicationContext {
	
	public static LoginActivity LOGIN_ACTIVITY;
	
	public static MessageBoxActivity IM_LIST_ACTIVITY;
	
	public static ChatRoomActivity MAIN_ACTIVITY;
	
	public static String CURRENT_USER;
	
	
	public static SimpleWebSocketClient WEB_SOCKET_CLIENT;
	
	/**
	 * init, connect/reconnect WebSocket
	 * 同步方式连接WebSocket
	 * @return
	 */
	public static boolean webSocketConnectSync() {
		
		/**
		 * WebSocketClient不可以复用，否则会报异常
		 * java.lang.IllegalStateException: WebSocketClient objects are not reuseable
		 */
		try {
			WEB_SOCKET_CLIENT = new SimpleWebSocketClient( new URI( "ws://192.168.191.1/" ), new Draft_17());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
		
		boolean connected = false;
		try {
			connected = WEB_SOCKET_CLIENT.connectBlocking();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return connected;
	}
	
	/**
	 * 通过WebSocket发送ProtoBuf格式的数据
	 * @param message
	 */
	public static void sendMessage(Message message) {
		
		byte[] data = MessageProtoConverter.toByteArray(message);
		
		//DEBUG INFO
		System.out.print("Send:");
		for(int i=0 ; i< data.length; i++) {
			System.out.print(data[i]+",");
		}
		System.out.println();
		
		WEB_SOCKET_CLIENT.send(data);
	}

	/**
	 * 消息分发
	 * 将来自WebSocket的消息分发到不同的处理器
	 *  eg : 将消息分发给不同的Activity
	 *  
	 * @param message 来自WEB_SOCKET_CLIENT,解释后的消息
	 */
	public static void dispatchMessage(Message message) {
		
		if(message.getType() == Message.TYPE_LOGIN) {
			
			android.os.Message msg = android.os.Message.obtain(LOGIN_ACTIVITY.getMessageHandler(), LoginActivity.LOGIN_RESULT, 0, 0, message);
			
			//给主线程的Looper插入一条消息
			msg.sendToTarget();
			
			return;
		}
		
		if(message.getType() == Message.TYPE_TEXT) {
			
			android.os.Message msg = android.os.Message.obtain(MAIN_ACTIVITY.getMessageHandler(), ChatRoomActivity.MESSAGE_RECEIVED, 0, 0, message.getContent());
			
			//给主线程的Looper插入一条消息
			msg.sendToTarget();
			
			return;
		}
	}
	
	/**
	 * 退出程序
	 */
	public static void exit() {
		WEB_SOCKET_CLIENT.close();
		
		IM_LIST_ACTIVITY.finish();
		LOGIN_ACTIVITY.finish();
	}
}
