/**   
* 文件名：Activity_OrderContinue.java 
* 类名称：Activity_OrderContinue   
* 类描述：      
* 创建人：诸葛飞扬。JJ   
* 创建时间：2015-1-11 下午3:47:13  
* Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
* 版本信息：    
* 修改人：jj   
* 修改时间：2015-1-11 下午3:47:13   
* 修改备注：   
*/ 
package com.wanqin.ktv.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;
import com.wanqin.ktv.shop.Activity_OrderOnline;

/**
 * @ClassName: Activity_OrderContinue
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-11 下午3:47:13
 * 
 */
public class Activity_OrderContinue extends SherlockActivity implements
		OnClickListener {

	private ImageView left_Button;
	private ImageView right_Button;
	private Button continue_Button;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_ordercontinue);
		initViews();
	}

	private void initViews() {
		continue_Button=(Button) findViewById(R.id.continue_Button);
		continue_Button.setOnClickListener(this);
		listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new Adapter_ListView());
	}
	private void initActionBar() {

		LayoutInflater inflater = getLayoutInflater();
		View actionBarView = inflater.inflate(R.layout.actionbar_image, null);
		actionBarView.setOnClickListener(this);
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.white));
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setHomeButtonEnabled(false);
		getSupportActionBar().setLogo(R.drawable.ic_launcher);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		// getSupportActionBar().setTitle("网易新闻");
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		getSupportActionBar().setCustomView(actionBarView);
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		left_Button = (ImageView) actionBarView
				.findViewById(R.id.left_ActionBar_Button);
		left_Button.setImageResource(R.drawable.selector_back);
		left_Button.setOnClickListener(this);
		left_Button.setVisibility(View.VISIBLE);
		TextView tttTextView = (TextView) actionBarView
				.findViewById(R.id.title_ActionBar);

		tttTextView.setText("我的订单");

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			finish();
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_right_out);
			break;

		case R.id.continue_Button:
			Intent intent=new Intent(this, Activity_OrderOnline.class);
			intent.putExtra("title", getIntent().getStringExtra("title"));
			startActivity(intent);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			finish();
			break;
		}

	}
	class Adapter_ListView extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 15;
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
			view=LayoutInflater.from(Activity_OrderContinue.this).inflate(R.layout.item_listview_gouwuche, null);
			
			return view;
		}

	}
}
