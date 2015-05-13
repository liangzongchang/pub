package com.wanqin.ktv.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wanqin.ktv.R;
import com.wanqin.ktv.main.Adapter_ListView;
import com.wanqin.ktv.supperclass.MyActivity;
import com.wanqin.ktv.utils.JToast;

public class Activity_ScoreMall extends MyActivity implements OnClickListener {
	private ImageView left_Button;
	private TextView tttTextView;
	private Button right_Button;
	private GridView gridView;
	private Adapter_GridView adapter_GridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_mall);
		initActionBar();
		initViews();
	}

	private void initViews() {
		gridView = (GridView) findViewById(R.id.gridView);
		adapter_GridView=new Adapter_GridView();
		gridView.setAdapter(adapter_GridView);
	}

	/**
	 * @Description: TODO(初始化Actionbar)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 上午10:17:20
	 */
	private void initActionBar() {

		LayoutInflater inflater = getLayoutInflater();
		View actionBarView = inflater.inflate(R.layout.actionbar_image, null);
		actionBarView.setOnClickListener(this);
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.transparent));
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
		tttTextView = (TextView) actionBarView
				.findViewById(R.id.title_ActionBar);

		tttTextView.setText("积分商城");

		View right_Button = findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}
	int count=21;
	class Adapter_GridView extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return count;
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
			view = LayoutInflater.from(Activity_ScoreMall.this).inflate(
					R.layout.item_gridview_score_mall, null);
			Button duihuan_Button=(Button) view.findViewById(R.id.duihuan_Button);
			duihuan_Button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					initDialog();
				}
			});
			return view;
		}
		protected void initDialog() {
			// TODO Auto-generated method stub
			AlertDialog.Builder builder=new AlertDialog.Builder(Activity_ScoreMall.this);
			builder.setTitle("温馨提示");
			builder.setMessage("请确定要使用5000积分兑换一个红宝石吗？");
			builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					JToast.showToast(getApplicationContext(), "兑换成功");
					//count--;
					//adapter_GridView.notifyDataSetChanged();
					dialog.dismiss();
					
				}
			});
			builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					
				}
			});
			builder.create().show();
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
