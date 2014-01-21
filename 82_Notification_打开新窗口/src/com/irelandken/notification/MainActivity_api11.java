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

public class MainActivity_api11 extends Activity {

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
        // this notification---  
		Intent intent = new Intent(this, NotificationActivity.class);
		intent.putExtra("notificationID", notificationID);
		
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		Notification notification = new Notification(
				R.drawable.ic_launcher, 
				"Reminder: Meeting starts in 5 minutes", 
				System.currentTimeMillis());
		
		new Notification.Builder(this)
        .setContentTitle("新信息")
        .setContentText("你的支付宝收入1000万")
        .setSmallIcon(R.drawable.mail)
       // .setLargeIcon(aBitmap)
        .build();

		
		
	//	notification.setLatestEventInfo(this, from, message, pIntent);
		
		//震动
        //---100ms delay, vibrate for 250ms, pause for 100 ms and  
        // then vibrate for 500ms---  
		notification.vibrate = new long[]{100, 250, 100, 500};
		
		//显示通知
		nm.notify(notificationID, notification);
	}
}
