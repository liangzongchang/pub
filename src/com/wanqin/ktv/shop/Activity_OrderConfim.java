/**   
 * 文件名：Activity_OrderConfim.java 
 * 类名称：Activity_OrderConfim   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2015-1-11 下午12:51:02  
 * Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2015-1-11 下午12:51:02   
 * 修改备注：   
 */
package com.wanqin.ktv.shop;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.wanqin.ktv.main.Adapter_ListView;
import com.wanqin.ktv.utils.JToast;

/**
 * @ClassName: Activity_OrderConfim
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-11 下午12:51:02
 * 
 */
public class Activity_OrderConfim extends SherlockActivity implements
		OnClickListener {
	private Button onlinePay_Button, offline_Pay_Button;
	private ListView listView;
	private ImageView left_Button;
	private ImageView right_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orderconfirm);
		initActionBar() ;
		initViews();
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

		tttTextView.setText(getIntent().getStringExtra("订单确认"));

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}
	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2015-1-11 下午2:19:33
	 */
	private void initViews() {
		onlinePay_Button = (Button) findViewById(R.id.onlinePay_Button);
		offline_Pay_Button = (Button) findViewById(R.id.offline_Pay_Button);
		listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new Adapter_ListView());
		onlinePay_Button.setOnClickListener(this);
		offline_Pay_Button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			exitActivity();
			break;

		case R.id.onlinePay_Button:
			initSuccessDialog();
			break;
		case R.id.offline_Pay_Button:
			initConfimDialog();
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
			view=LayoutInflater.from(Activity_OrderConfim.this).inflate(R.layout.item_listview_gouwuche, null);
			
			return view;
		}

	}
	protected void initConfimDialog() {
		AlertDialog.Builder builder=new AlertDialog.Builder(Activity_OrderConfim.this);
		builder.setMessage("感谢您的订购，我们将在10分钟内联系您!");
		builder.setPositiveButton("申请泊车", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				JToast.showToast(getApplicationContext(), "申请泊车成功!");
				dialog.dismiss();
				exitActivity();
			}
		});
		builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}
	protected void initSuccessDialog() {
		AlertDialog.Builder builder=new AlertDialog.Builder(Activity_OrderConfim.this);
		builder.setTitle("支付成功");
		builder.setMessage("您的订单已支付成功!");
		builder.setPositiveButton("申请泊车", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				JToast.showToast(getApplicationContext(), "申请泊车成功!");
				dialog.dismiss();
				exitActivity();
			}
		});
		builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				exitActivity();
			}
		});
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}

	private void exitActivity() {
		finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
		if (Activity_OrderOnline.getInstance()!=null) {
			Activity_OrderOnline.getInstance().finish();
		}
	}

}
