/**   
 * 文件名：Activity_ShopSingle.java 
 * 类名称：Activity_ShopSingle   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2015-1-10 下午9:21:51  
 * Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2015-1-10 下午9:21:51   
 * 修改备注：   
 */
package com.wanqin.ktv.shop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;
import com.wanqin.ktv.chat.Activity_CharRoom;
import com.wanqin.ktv.chat.Activity_ChatInSingleShop;
import com.wanqin.ktv.utils.JToast;

/**
 * @ClassName: Activity_ShopSingle
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-10 下午9:21:51
 * 
 */
public class Activity_ShopSingle extends SherlockActivity implements
		OnClickListener {

	private ImageView left_Button;
	private Button right_Button;
	private GridView gridView;
	private Button map_Button, chat_Button, detail_Button,pingjia_Button;
	private TextView pic_TextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_shopsingle);
		initViews();
	}

	private void initViews() {
		gridView = (GridView) findViewById(R.id.gridView);
		pingjia_Button = (Button) findViewById(R.id.pingjia_Button);
		chat_Button = (Button) findViewById(R.id.chat_Button);
		detail_Button = (Button) findViewById(R.id.detail_Button);
		pic_TextView = (TextView) findViewById(R.id.pic_TextView);
		pic_TextView.setOnClickListener(this);
		pingjia_Button.setOnClickListener(this);
		chat_Button.setOnClickListener(this);
		detail_Button.setOnClickListener(this);
		pingjia_Button.setOnClickListener(this);
		gridView.setAdapter(new Adapter_GridView());
	}

	private void initActionBar() {

		LayoutInflater inflater = getLayoutInflater();
		View actionBarView = inflater.inflate(R.layout.actionbar_button, null);
		actionBarView.setOnClickListener(this);
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.bg_actionbar));
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

		right_Button = (Button) findViewById(R.id.right_ActionBar_Button);
		right_Button.setText("地图");
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.VISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.right_ActionBar_Button:
			Intent intent = new Intent(this, Activit_ShopMap.class);
			intent.putExtra("title", getIntent().getStringExtra("title"));
			startActivity(intent);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		case R.id.pingjia_Button:
			Intent pingjia_Button = new Intent(this, Activity_Pingjia.class);
			startActivity(pingjia_Button);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		case R.id.chat_Button:
			Intent intent_chat = new Intent(this,
					Activity_CharRoom.class);
			intent_chat.putExtra("title", getIntent().getStringExtra("title"));
			startActivity(intent_chat);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		case R.id.detail_Button:
			JToast.showToast(getApplicationContext(), "店铺详细内容");
			break;
		case R.id.pic_TextView:
			Intent intent_pic = new Intent(this, Activity_PicSingleShop.class);
			intent_pic.putExtra("title", getIntent().getStringExtra("title"));
			startActivity(intent_pic);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		case R.id.left_ActionBar_Button:
			finish();
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
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
			view = LayoutInflater.from(Activity_ShopSingle.this).inflate(
					R.layout.item_gridview_shopsingle, null);
			TextView name_TextView = (TextView) view
					.findViewById(R.id.name_TextView);
			Button book_Button = (Button) view.findViewById(R.id.book_Button);
			name_TextView.setText("包厢"+(position+1));
			switch (position % 3) {
			case 0:
				book_Button.setText("空包");
				book_Button.setBackgroundResource(R.drawable.selector_click_kongbao);
				name_TextView.setText("大包厢"+(608+position));
				break;

			case 1:
				book_Button.setText("已预订");
				book_Button.setBackgroundResource(R.color.green);
				break;
			case 2:
				book_Button.setText("已进客");
				book_Button.setBackgroundResource(R.color.red_pink);
				break;
			}
			view.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					initDialog();
				}
			});
			return view;
		}

		
		protected void initDialog() {
			AlertDialog.Builder builder=new AlertDialog.Builder(Activity_ShopSingle.this);
		
			View view=LayoutInflater.from(Activity_ShopSingle.this).inflate(R.layout.dialog_select_ordertype, null);
			Button online_Button=(Button) view.findViewById(R.id.online_Button);
			Button offline_Button=(Button) view.findViewById(R.id.offline_Button);
			builder.setView(view);
			final AlertDialog dialog=builder.create();
			online_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					dialog.dismiss();
					Intent intent=new Intent(Activity_ShopSingle.this, Activity_OrderOnline.class);
					intent.putExtra("title", getIntent().getStringExtra("title"));
					Activity_ShopSingle.this.startActivity(intent);
					Activity_ShopSingle.this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});
			offline_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.dismiss();
					initConfimDialog();
				}
			});
			
		
			dialog.show();
		}
		

		/**
		 * @Description: TODO(*)
		 * @author 诸葛飞扬。JJ
		 * @date 2015-1-11 上午11:49:55
		 */
		protected void initConfimDialog() {
			AlertDialog.Builder builder=new AlertDialog.Builder(Activity_ShopSingle.this);
			builder.setMessage("感谢您的订购，我们将在10分钟内联系您!");
			builder.setPositiveButton("申请泊车", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					JToast.showToast(getApplicationContext(), "申请泊车成功!");
					dialog.dismiss();
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

	}
}
