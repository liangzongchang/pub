/**   
 * �ļ�����Activity_OrderConfim.java 
 * �����ƣ�Activity_OrderConfim   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2015-1-11 ����12:51:02  
 * Copyright �����JJ Corporation 2015 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2015-1-11 ����12:51:02   
 * �޸ı�ע��   
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
 * @author �����JJ
 * @date 2015-1-11 ����12:51:02
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

		tttTextView.setText(getIntent().getStringExtra("����ȷ��"));

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}
	/**
	 * @Description: TODO(*)
	 * @author �����JJ
	 * @date 2015-1-11 ����2:19:33
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
		builder.setMessage("��л���Ķ��������ǽ���10��������ϵ��!");
		builder.setPositiveButton("���벴��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				JToast.showToast(getApplicationContext(), "���벴���ɹ�!");
				dialog.dismiss();
				exitActivity();
			}
		});
		builder.setNegativeButton("����", new DialogInterface.OnClickListener() {
			
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
		builder.setTitle("֧���ɹ�");
		builder.setMessage("���Ķ�����֧���ɹ�!");
		builder.setPositiveButton("���벴��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				JToast.showToast(getApplicationContext(), "���벴���ɹ�!");
				dialog.dismiss();
				exitActivity();
			}
		});
		builder.setNegativeButton("����", new DialogInterface.OnClickListener() {
			
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
