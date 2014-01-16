package com.irelandken.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Service������Ҫ�����Ǻ�̨����
 * @author kenzfliang
 * 
 * ���»ص�����������main�߳���ִ��
 */
public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("*** Service onBind()");

		return null;
	}
	
	/**
	 * ͬһ������, ���ִ��ContextWrapper.startService(Intent service)ֻ�����onCreate()һ��
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
	 * ͬһ������, ÿ��ִ��ContextWrapper.startService(Intent service), ����ִ��һ��onStartCommand
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("*** Service onStartCommand()");
		
		
		
		return Service.START_CONTINUATION_MASK; //����ִ��
	}

}
