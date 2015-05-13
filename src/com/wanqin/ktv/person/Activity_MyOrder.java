/**   
 * �ļ�����Activity_MyOrder.java 
 * �����ƣ�Activity_MyOrder   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2015-1-11 ����2:53:38  
 * Copyright �����JJ Corporation 2015 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2015-1-11 ����2:53:38   
 * �޸ı�ע��   
 */
package com.wanqin.ktv.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;

/**
 * @ClassName: Activity_MyOrder
 * @Description: TODO(*)
 * @author �����JJ
 * @date 2015-1-11 ����2:53:38
 * 
 */
public class Activity_MyOrder extends SherlockActivity implements
		OnClickListener {
	private ListView listView;
	private ImageView left_Button;
	private ImageView right_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_myorder);
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
		// getSupportActionBar().setTitle("��������");
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

		tttTextView.setText("�ҵĶ���");

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}

	private void initViews() {
		listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new Adapter_ListView());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			finish();
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_right_out);
			break;

		default:
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
			// TODO Auto-generated method stub
			view = LayoutInflater.from(Activity_MyOrder.this).inflate(
					R.layout.item_listview_myorders, null);
			final TextView name_TextView = (TextView) view
					.findViewById(R.id.name_TextView);
			TextView number_TextVIew = (TextView) view
					.findViewById(R.id.number_TextVIew);
			TextView type_TextView = (TextView) view
					.findViewById(R.id.type_TextView);
			LinearLayout background = (LinearLayout) view
					.findViewById(R.id.background);
			if (position < 4) {
				type_TextView.setText("����:δ����");
				view.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Activity_MyOrder.this,
								Activity_OrderContinue.class);
						intent.putExtra("title", name_TextView.getText().toString().replace("�Ƶ����ƣ�", ""));
						Activity_MyOrder.this.startActivity(intent);
						Activity_MyOrder.this.overridePendingTransition(
								R.anim.push_left_in, R.anim.push_left_out);
					}
				});
			} else {
				background.setBackgroundResource(R.color.transparent_high);
				type_TextView.setText("����:�ѽ���");
			}
			return view;
		}

	}
}