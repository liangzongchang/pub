package com.wanqin.ktv.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wanqin.ktv.R;
import com.wanqin.ktv.main.Adapter_ListView;
import com.wanqin.ktv.supperclass.MyActivity;

public class Activity_caller extends MyActivity implements OnClickListener {
	private ListView listView;
	private ImageView left_Button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_nominate);
		initActionBar();
		listView=(ListView) findViewById(R.id.listView);
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

		tttTextView.setText("最近访客");

		left_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		left_Button.setOnClickListener(this);
		left_Button.setVisibility(View.INVISIBLE);
	}
	class Adapter_ListView extends BaseAdapter{

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
			view=LayoutInflater.from(Activity_caller.this).inflate(R.layout.item_listview_caller, null);
			
			return view;
		}
		
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

}
