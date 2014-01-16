package com.irelandken.layout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;

/**
 * @See http://blog.csdn.net/manoel/article/details/7582454
 * @author kenzfliang
 */

public class MainActivity extends Activity {

	private String[] list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		list = super.getResources().getStringArray(R.array.presidents_array);
		
		ListView listView = new ListView(this);
		
		listView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, list));
		
		super.setContentView(listView);
		
	}
}
