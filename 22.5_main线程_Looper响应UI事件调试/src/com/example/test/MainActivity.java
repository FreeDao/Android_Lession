package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 1:���� android.os.Looper, 
 *   ��prepare(),prepareMainLooper(), loop(), quit()
 *   ��������Ӷϵ�
 * 2:����
 * 
 * ���Է���main�̶߳�UI�����¼��Ĵ���
 * 
 * ����Ϊ�������:
 * 1:�����ػ��¼�,�����һ��message(���Ž�Looper��MessageQueue),
 *   ��HandlerΪ: android.view.Choreographer$FrameHandler
 *   ���msg����android.view.Choreographer$FrameDisplayEventReceiver����,
 *   Ȼ���ػ�
 *   
 * 2:�����ť��, һ��msg�ᱻ�Ž�Looper��MessageQueue, 
 *   ��HanlderΪ: (android.view.ViewRootImpl$ViewRootHandler)
 *   Ȼ�� android.view.View.performClick() �ᱻ����
 * 
 * @author kenzfliang
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btn = new Button(this);
        btn.setText("Click Me");
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("on click:" + v );
				
				((Button)v).setText("I'm Clicked!");
			}
		});
        
        super.setContentView(btn);
    }
}
