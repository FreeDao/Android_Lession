package com.irelandken.service;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class MainActivity extends Activity {

	private Button startBtn;
	private Button stopBtn;
	
	private Button bindBtn;
	private Button unbindBtn;
	
	private ServiceConnection serviceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			try {
				System.out.println("### Service Connect Success . service = " + service.getInterfaceDescriptor());
			} catch (RemoteException e) {
				e.printStackTrace();
			};
		}
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
			System.out.println("### onServiceDisconnected ");
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.startBtn = (Button) super.findViewById(R.id.startBtn);
		this.stopBtn  = (Button) super.findViewById(R.id.stopBtn);
		
		this.bindBtn  = (Button) super.findViewById(R.id.bindBtn);
		this.unbindBtn= (Button) super.findViewById(R.id.unbindBtn);
		
		startBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//¿˚”√Intent∆Ù∂ØService
				MainActivity.this.startService(new Intent(MainActivity.this, MyService.class));
			}
		});
		
		stopBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Õ£÷πService
				MainActivity.this.stopService(new Intent(MainActivity.this, MyService.class));
			}
		});
		
		//--------------------------------
		
		bindBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				MainActivity.this.bindService(
						new Intent(MainActivity.this, MyService.class), 
						MainActivity.this.serviceConnection, 
						Context.BIND_AUTO_CREATE);
			}
		});
		
		unbindBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				MainActivity.this.unbindService(MainActivity.this.serviceConnection);
			}
		});
		
	}

}
