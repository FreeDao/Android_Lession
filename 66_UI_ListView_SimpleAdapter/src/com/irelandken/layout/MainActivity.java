package com.irelandken.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;

/**
 * @See http://blog.csdn.net/manoel/article/details/7582454
 * @author kenzfliang
 */

public class MainActivity extends Activity {

	private List<Map<String, String>> data;
	
	private ListView datalist; //定义ListView组件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Window.FEATURE_NO_TITLE : 隐藏Title
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);

		//配置ListView
		datalist = (ListView) super.findViewById(R.id.datalist);
		
		data = new ArrayList<Map<String,String>>();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "今天天气很好!");
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		data.add(map);
		
		final SimpleAdapter adapter = new SimpleAdapter(this, data, 
				R.layout.text_message_view_left_item, 
				new String[]{"msg"},              //Map中的key名称
				new int[]{R.id.msgTo}             //模板中的组件资源ID
				);
		datalist.setAdapter(adapter);
		
		
		Button sendBtn = (Button) super.findViewById(R.id.sendBtn);
		sendBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				EditText msgEdit = (EditText) MainActivity.this.findViewById(R.id.msgEdit);
				
				if(msgEdit.getTextSize() == 0) {
					return;
				}
				
				String msg = msgEdit.getText().toString();
				
				Map<String,String> map = new HashMap<String,String>();
				
				map.put("msg", msg);
				
				data.add(map);
				
				//通知ListView, Data已改变, 刷新ListView
				adapter.notifyDataSetChanged();
				
				datalist.scrollTo(0, adapter.getCount() - 1);
			}
		});
		
		Button personInfoBtn = (Button) super.findViewById(R.id.personInfoBtn);
		personInfoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//datalist.getchild
				datalist.scrollTo(0, 400);
			}
		});
		
	}
}
