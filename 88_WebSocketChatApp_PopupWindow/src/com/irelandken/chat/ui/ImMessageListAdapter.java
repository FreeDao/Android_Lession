package com.irelandken.chat.ui;

import java.util.List;
import java.util.Map;

import com.irelandken.chat.ApplicationContext;
import com.irelandken.chat.R;
import com.irelandken.chat.activity.LoginActivity;
import com.irelandken.chat.activity.ChatRoomActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ImMessageListAdapter extends BaseAdapter {

	public static final int TYPE_SEARCH_BOX = 0;
	public static final int TYPE_ITEM_ODD = 1;
	public static final int TYPE_ITEM_EVEN = 2;
	
	private View search_box;
	
	//message:　type(int), message(String)
	private List<Map<String,Object>> msgList;
	
	//从XML构建Layout的工具
    private LayoutInflater mInflater;
	
	public ImMessageListAdapter(Context context, List<Map<String, Object>> msgList) {
		super();
		this.msgList = msgList;
		
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return msgList.size();
	}

	@Override
	public Object getItem(int position) {
		return msgList.get(position);
	}

	/**
	 * Item的id就是Item在List里的序号
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public int getItemViewType(int position) {
		
		if(position == 0) {
			return TYPE_SEARCH_BOX;
		}
		
		Map<String,Object> msg = msgList.get(position);
		return (Integer) msg.get("type");
	}

	@Override
	public int getViewTypeCount() {
		return 3;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(position == 0) {
			if(search_box == null) {
				 search_box = mInflater.inflate(R.layout.immessage_list_search_box, parent, false);
			}
			return search_box;
		}
		
		Map<String, Object> message = msgList.get(position);
		
		//重用old view, 或 重XML新构建一个view
		//对于重用的convertView, 其类对于其position一定是正确的
		View view = convertView;
		if(view == null) {
			int type = getItemViewType(position);
			
			switch (type) {
			case TYPE_ITEM_ODD:
				view = mInflater.inflate(R.layout.im_list_item_select_odd, parent, false);
				break;
			case TYPE_ITEM_EVEN:
				view = mInflater.inflate(R.layout.im_list_item_select_even, parent, false);
				break;
			}
			
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
					
					//设置打开OtherActivity
					intent.setClass(ApplicationContext.IM_LIST_ACTIVITY, ChatRoomActivity.class);
					
					TextView friendNameView = (TextView) v.getTag();
					
					//传送数据
					//intent.putExtra("username", "XXX");
					ApplicationContext.CURRENT_USER = friendNameView.getText().toString();
					
					ApplicationContext.IM_LIST_ACTIVITY.startActivity(intent);
				}
			});
			
			//将要经常访问的msgView人为tag存起来, 下次就不用通过findViewById来查找,更快
			TextView friendNameView = (TextView) view.findViewById(R.id.friend_name);
			view.setTag(friendNameView);
		}

		//写数据
		TextView friendNameView = (TextView) view.getTag();

		String name = (String) message.get("friendName");
		friendNameView.setText(name);
		
		return view;
	}

}
