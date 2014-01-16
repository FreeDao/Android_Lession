package com.irelandken.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irelandken.chat.R;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.Activity;

/**
 * @See http://blog.csdn.net/manoel/article/details/7582454
 * @author kenzfliang
 */

public class MainActivity extends Activity {

	private List<Map<String, Object>> data;
	
	private ListView datalist; //定义ListView组件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);

		//配置ListView
		datalist = (ListView) super.findViewById(R.id.datalist);
		
		data = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", "今天天气很好!");
		map.put("type", ChatAdapter.TYPE_LEFT_TEXT);
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("msg", "今天天气很好!");
		map2.put("type", ChatAdapter.TYPE_RIGHT_TEXT);
		
		data.add(map);
		data.add(map2);
		data.add(map);
		data.add(map2);
		data.add(map);
		data.add(map);
		data.add(map2);
		data.add(map);
		data.add(map2);
		data.add(map);
		data.add(map2);
		data.add(map2);
		data.add(map);
		
		final ChatAdapter adapter = new ChatAdapter(this, data);
		datalist.setAdapter(adapter);
		
		
		Button sendBtn = (Button) super.findViewById(R.id.sendBtn);
		sendBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				EditText msgEdit = (EditText) MainActivity.this.findViewById(R.id.msgEdit);
				
				String msg = msgEdit.getText().toString();
				
				if(msg.length() == 0) {
					return;
				}
				
				Map<String,Object> map = new HashMap<String,Object>(2);
				map.put("msg", msg);
				map.put("type", ChatAdapter.TYPE_RIGHT_TEXT);
				
				data.add(map);
				
				//通知ListView, Data已改变, 刷新ListView
				adapter.notifyDataSetChanged();
				
				//清空输入框
				msgEdit.setText("");
				
				datalist.scrollTo(0, adapter.getCount() - 1);
			}
		});
		
		Button personInfoBtn = (Button) super.findViewById(R.id.personInfoBtn);
		personInfoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//datalist.getchild
				//datalist.scrollTo(0, 400);
			}
		});
		
	}
}
