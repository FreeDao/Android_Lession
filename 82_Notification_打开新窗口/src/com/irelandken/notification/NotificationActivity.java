package com.irelandken.notification;

import com.irelandken.notification.R;

import android.os.Bundle;
import android.view.Window;
import android.app.Activity;
import android.app.NotificationManager;

/**
 * @See http://blog.csdn.net/manoel/article/details/7578997
 * 
 * 通知栏的Notification被点击后，NotificationView会被打开
 * @author irelandKen
 *
 */
public class NotificationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.notification);
		
		// ---look up the notification manager service---  
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		//这个NotificationView被打开后，隐藏通知栏的通知
		// ---cancel the notification that we started--- 
		int notificationID = getIntent().getExtras().getInt("notificationID");
		nm.cancel(notificationID);
	}
}
