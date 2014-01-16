package com.irelandken.chat;

import java.util.List;
import java.util.Map;

import com.irelandken.chat.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChatMessageListAdapter extends BaseAdapter {

	public static final int TYPE_LEFT_TEXT = 0;
	public static final int TYPE_RIGHT_TEXT = 1;
	
	//message:　type(int), message(String)
	private List<Map<String,Object>> msgList;
	
	//从XML构建Layout的工具
    private LayoutInflater mInflater;
	
	public ChatMessageListAdapter(Context context, List<Map<String, Object>> msgList) {
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
		Map<String,Object> msg = msgList.get(position);
		return (Integer) msg.get("type");
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Map<String, Object> message = msgList.get(position);
		
		//重用old view, 或 重XML新构建一个view
		//对于重用的convertView, 其类对于其position一定是正确的
		View view = convertView;
		if(view == null) {
			int type = getItemViewType(position);
			
			switch (type) {
			case TYPE_LEFT_TEXT:
				view = mInflater.inflate(R.layout.text_message_view_left_item, parent, false);
				break;
				
			case TYPE_RIGHT_TEXT:
				view = mInflater.inflate(R.layout.text_message_view_right_item, parent, false);
				break;
			}
			
			//将要经常访问的msgView人为tag存起来, 下次就不用通过findViewById来查找,更快
			TextView msgView = (TextView) view.findViewById(R.id.msgTo);
			view.setTag(msgView);
		}

		//写数据
		TextView msgView = (TextView) view.getTag();
		msgView.setText((String)message.get("msg"));
		
		return view;
	}

}
