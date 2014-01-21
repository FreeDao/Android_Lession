package com.irelandken.notification;

import com.irelandken.notification.R;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

/**
 * @See http://blog.csdn.net/manoel/article/details/7578997
 * @author kenzfliang
 */

public class MainActivity extends Activity {

	int notificationID = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		
		Button btn = (Button) super.findViewById(R.id.noticeBtn);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 displayNotification();
			}
		});
	}

	protected void displayNotification() {
		
        //---PendingIntent to launch activity if the user selects 
		//1:创建PendingIntent
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, super.getIntent(), PendingIntent.FLAG_UPDATE_CURRENT);
		
		//2:创建Notification
		Notification notification = new Notification(
				R.drawable.mail, 
				"新信息：你的支付宝收入1000万", 
				System.currentTimeMillis());
		
		String title = "新信息";
		String content = "你的支付宝收入1000万";
		
		//pIntent: 通知栏上的通知被点击后，被启动的intent
		notification.setLatestEventInfo(this, title, content, pIntent);
		
		//震动
        //---100ms delay, vibrate for 250ms, pause for 100 ms and  
        // then vibrate for 500ms---  
		notification.vibrate = new long[]{100, 250, 100, 500};
		
		//3:显示通知
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		notificationManager.notify(notificationID, notification);
	}
}
