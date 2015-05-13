/**   
* 文件名：Adapter_ListView.java 
* 类名称：Adapter_ListView   
* 类描述：      
* 创建人：诸葛飞扬。JJ   
* 创建时间：2015-1-2 下午3:52:53  
* Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
* 版本信息：    
* 修改人：jj   
* 修改时间：2015-1-2 下午3:52:53   
* 修改备注：   
*/ 
package com.wanqin.ktv.main;

import org.json.JSONArray;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wanqin.ktv.R;

/**
 * @ClassName: Adapter_ListView
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-2 下午3:52:53
 * 
 */
public class Adapter_ListView extends BaseAdapter {
	private Context context;
	private JSONArray jsonArray;
	private int i;
	
	public Adapter_ListView(Context context, JSONArray jsonArray) {
		super();
		this.context = context;
		this.jsonArray = jsonArray;
	}
	public Adapter_ListView(Context context, int i) {
		super();
		this.context = context;
		this.i = i;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return i==0?4:i;
	}


	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		view=LayoutInflater.from(context).inflate(R.layout.item_listview_home, null);
		TextView originalCost_TextView=(TextView) view.findViewById(R.id.originalCost_TextView);
		originalCost_TextView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); 
	
		return view;
	}

}
