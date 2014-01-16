package com.irelandken.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Service的最主要特征是后台运行
 * @author kenzfliang
 * 
 * 以下回调方法都是在main线程中执行
 */
public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("*** Service onBind()");

		return null;
	}
	
	/**
	 * 同一个服务, 多次执行ContextWrapper.startService(Intent service)只会调用onCreate()一次
	 */
	@Override
	public void onCreate() {
		System.out.println("*** Service OnCreate()");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		System.out.println("*** Service onDestroy()");
		super.onDestroy();
	}
	
	/**
	 * 同一个服务, 每次执行ContextWrapper.startService(Intent service), 都会执行一次onStartCommand
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("*** Service onStartCommand()");
		
		
		
		return Service.START_CONTINUATION_MASK; //继续执行
	}

}
