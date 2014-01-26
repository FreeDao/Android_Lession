package com.irelandken.chat.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irelandken.chat.ApplicationContext;
import com.irelandken.chat.R;
import com.irelandken.chat.message.Message;
import com.irelandken.chat.ui.ImMessageListAdapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;

/**
 * 消息盒子窗口
 * @See http://blog.csdn.net/manoel/article/details/7582454
 * @author kenzfliang
 */
public class MessageBoxActivity extends Activity {

	private List<Map<String, Object>> messageList;
	
	private ListView messageListView; //定义ListView组件
	
	private ImMessageListAdapter imMessageListAdapter;
	
	public static final int MESSAGE_RECEIVED = 1;
	
	private PopupWindow popupWindow;
	
	private View mainView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_immessage_list);
		
		ApplicationContext.IM_LIST_ACTIVITY = this;
		
		//主窗口
		mainView = super.findViewById(R.id.imMessageListMainView);
		
		//配置ListView
		messageListView = (ListView) super.findViewById(R.id.imMessageList);
		
		messageList = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map = new HashMap<String,Object>(2);
		map.put("type", ImMessageListAdapter.TYPE_SEARCH_BOX);
		
		messageList.add(map);
		
		map = new HashMap<String,Object>(2);
		map.put("type", ImMessageListAdapter.TYPE_ITEM_ODD);
		map.put("friendName", "易信活动");
		
		Map<String,Object> map2 = new HashMap<String,Object>(2);
		map2.put("type", ImMessageListAdapter.TYPE_ITEM_EVEN);
		map2.put("friendName", "易信活动");
		
		messageList.add(map);
		messageList.add(map2);
		messageList.add(map);
		messageList.add(map2);
		messageList.add(map);
		messageList.add(map2);
		messageList.add(map);
		messageList.add(map2);
		messageList.add(map);
		messageList.add(map2);
		
		map = new HashMap<String,Object>(2);
		map.put("type", ImMessageListAdapter.TYPE_ITEM_ODD);
		map.put("friendName", "KEN");
		
		map2 = new HashMap<String,Object>(2);
		map2.put("type", ImMessageListAdapter.TYPE_ITEM_EVEN);
		map2.put("friendName", "xiaobai");
		
		messageList.add(map);
		messageList.add(map2);
		
		imMessageListAdapter = new ImMessageListAdapter(this, messageList);
		messageListView.setAdapter(imMessageListAdapter);
		
		createPopupWindow();
	}
	
	/**
	 * 创建“退出”弹出窗口
	 */
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
		
		//事件绑定(退出程序)
		Button exitBtn = (Button) popupWindowView.findViewById(R.id.exitBtn);
		exitBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ApplicationContext.exit();
			}
		});
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_MENU) {
			openPopupWindow();
		}
		return super.onKeyUp(keyCode, event);
	}

	private void openPopupWindow() {
		
		//显示在主界面底部居中的位置
		popupWindow.showAtLocation(mainView, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		
	}
}
