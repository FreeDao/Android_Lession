package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 1:进入 android.os.Looper, 
 *   在prepare(),prepareMainLooper(), loop(), quit()
 *   方法中添加断点
 * 2:调试
 * 
 * 调试分析main线程对UI各种事件的处理
 * 
 * 以下为分析结果:
 * 1:对于重绘事件,会产生一个message(被放进Looper的MessageQueue),
 *   其Handler为: android.view.Choreographer$FrameHandler
 *   这个msg会由android.view.Choreographer$FrameDisplayEventReceiver处理,
 *   然后重绘
 *   
 * 2:点击按钮后, 一个msg会被放进Looper的MessageQueue, 
 *   其Hanlder为: (android.view.ViewRootImpl$ViewRootHandler)
 *   然后 android.view.View.performClick() 会被调用
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
