/**   
* 文件名：Activity_OrderOnline.java 
* 类名称：Activity_OrderOnline   
* 类描述：      
* 创建人：诸葛飞扬。JJ   
* 创建时间：2015-1-11 下午12:03:20  
* Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
* 版本信息：    
* 修改人：jj   
* 修改时间：2015-1-11 下午12:03:20   
* 修改备注：   
*/ 
package com.wanqin.ktv.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wanqin.ktv.R;
import com.wanqin.ktv.utils.JToast;

/**
 * @ClassName: Activity_OrderOnline
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-11 下午12:03:20
 * 
 */
public class Activity_OrderOnline extends SherlockActivity implements
		OnClickListener {
	private ImageView left_Button;
	private ImageView right_Button;
	private GridView gridView;
	private TextView text1,text2,text3,text4;
	private Button submit_Button;
	private static Activity_OrderOnline activity_OrderOnline;
	public static Activity_OrderOnline getInstance(){
		return activity_OrderOnline;
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		activity_OrderOnline=this;
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_orderonline);
		initViews();
	}
	
	private void initViews() {
		gridView=(GridView) findViewById(R.id.gridView);
		gridView.setAdapter(new Adapter_GridView());
		text1=(TextView) findViewById(R.id.text1);
		text2=(TextView) findViewById(R.id.text2);
		text3=(TextView) findViewById(R.id.text3);
		text4=(TextView) findViewById(R.id.text4);
		text1.setOnClickListener(this);
		text2.setOnClickListener(this);
		text3.setOnClickListener(this);
		text4.setOnClickListener(this);
		submit_Button=(Button) findViewById(R.id.submit_Button);
		submit_Button.setOnClickListener(this);
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

		tttTextView.setText(getIntent().getStringExtra("title"));

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
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			break;

		case R.id.submit_Button:
			Intent intent=new Intent(Activity_OrderOnline.this, Activity_OrderConfim.class);
			Activity_OrderOnline.this.startActivity(intent);
			Activity_OrderOnline.this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		}
	}
	class Adapter_GridView extends BaseAdapter {
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 27;
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
			view = LayoutInflater.from(Activity_OrderOnline.this).inflate(
					R.layout.item_gridview_orderonline, null);
			RoundedImageView goods_RoundedImageView=(RoundedImageView) view.findViewById(R.id.goods_RoundedImageView);
			TextView shopcart_TextView=(TextView) view.findViewById(R.id.shopcart_TextView);
			TextView details_TextView=(TextView) view.findViewById(R.id.details_TextView);
			shopcart_TextView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					JToast.showToast(getApplicationContext(), "加入购物车成功");
				}
			});
			details_TextView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					JToast.showToast(getApplicationContext(), "暂无详情");
				}
			});
			return view;
		}
	}
}
