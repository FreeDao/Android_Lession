package com.irelandken.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;

/**
 * Service������Ҫ�����Ǻ�̨����
 * @author kenzfliang
 *
 */
public class MyService extends Service {

	private IBinder binder = new Binder(){

		@Override
		public String getInterfaceDescriptor() {
			return "MyServier Class ..";
		}
		
	};
	
	/**
	 * IBinder ��ͨ��Service���ص�Activity�����ϵ�һ�����ӵİ󶨶���
	 */
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("*** Service onBind()");

		return binder;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("*** Service onUnbind()");
		return super.onUnbind(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		System.out.println("*** Service onRebind()");
		super.onRebind(intent);
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
