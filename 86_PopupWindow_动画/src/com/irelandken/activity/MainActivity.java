package com.irelandken.activity;

import com.irelandken.notification.R;

import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;

/**
 * @See http://blog.csdn.net/manoel/article/details/7578997
 * @author kenzfliang
 */

public class MainActivity extends Activity {

	private PopupWindow popupWindow;
	
	private View mainView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		//主窗口
		mainView = super.findViewById(R.id.main);
		
		createPopupWindow();
	}

	private void createPopupWindow() {
		
		LayoutInflater mInflater = super.getLayoutInflater();
        
		View popupWindowView = mInflater.inflate(R.layout.exit_popwin, null);
			
		popupWindow = new PopupWindow(popupWindowView, 
											ViewGroup.LayoutParams.MATCH_PARENT, 
											ViewGroup.LayoutParams.WRAP_CONTENT);
		
		//为什么设置下面这行后，点击PopupWindow 外部区域时，PopupWindow消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		//取得焦点(使按钮可用等),PS:弹出窗口是模态的
		popupWindow.setFocusable(true);
		
		//设置窗口显示的动画
		popupWindow.setAnimationStyle(R.style.popup_win_animation);
		
		//事件绑定
		Button exitBtn = (Button) popupWindowView.findViewById(R.id.exitBtn);
		exitBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//隐藏弹出窗口
				if(popupWindow.isShowing()) {
					popupWindow.dismiss();
				}
			}
		});
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		
		if(keyCode == KeyEvent.KEYCODE_MENU) {

			openPopupWindow(null);
		}
		
		return super.onKeyUp(keyCode, event);
	}

	public void openPopupWindow(View v) {
		
		//显示在主界面底部居中的位置
		popupWindow.showAtLocation(mainView, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		
	}
}
