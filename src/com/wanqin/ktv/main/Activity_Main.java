/**   
 * 文件名：Activity_Main.java 
 * 类名称：Activity_Main   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-12-29 下午10:07:52  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-12-29 下午10:07:52   
 * 修改备注：   
 */
package com.wanqin.ktv.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Window;
import com.wanqin.ktv.R;
import com.wanqin.ktv.chat.Fragment_Public_Chatroom;
import com.wanqin.ktv.customview.MyViewPager;

/**
 * @ClassName: Activity_Main
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-12-29 下午10:07:52
 * 
 */
public class Activity_Main extends SherlockFragmentActivity implements
		OnClickListener, OnTouchListener {

	private LinearLayout home_LinearLayout, chat_LinearLayout,
			more_LinearLayout;
	private ImageView home_ImageView, chat_ImageView, more_ImageView,
			lushui_ImageView;
	private TextView home_TextView, chat_Textview, more_TextView;
	private View home_View, chat_View, more_View;
	private MyViewPager pager;

	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		initViews();
	}

	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-30 下午11:03:30
	 */
	private void initViews() {
		home_LinearLayout = (LinearLayout) findViewById(R.id.home_LinearLayout);
		chat_LinearLayout = (LinearLayout) findViewById(R.id.chat_LinearLayout);
		more_LinearLayout = (LinearLayout) findViewById(R.id.more_LinearLayout);
		home_LinearLayout.setOnClickListener(this);
		chat_LinearLayout.setOnClickListener(this);
		more_LinearLayout.setOnClickListener(this);
		home_ImageView = (ImageView) findViewById(R.id.home_ImageView);
		chat_ImageView = (ImageView) findViewById(R.id.chat_ImageView);
		more_ImageView = (ImageView) findViewById(R.id.more_ImageView);
		home_TextView = (TextView) findViewById(R.id.home_TextView);
		chat_Textview = (TextView) findViewById(R.id.chat_Textview);
		more_TextView = (TextView) findViewById(R.id.more_TextView);

		home_View = findViewById(R.id.home_View);
		chat_View = findViewById(R.id.chat_View);
		more_View = findViewById(R.id.more_View);
		lushui_ImageView = (ImageView) findViewById(R.id.lushui_ImageView);
		lushui_ImageView.setOnTouchListener(this);
		initViewPager();
	}

	class GoogleMusicAdapter extends FragmentPagerAdapter {

		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {

				return Fragment_Home.getInstance();
			} else if (position == 1) {

				return Fragment_Public_Chatroom.getInstance();
			} else if (position == 2) {

				return Fragment_More.getInstance();
			} else {
				return Fragment_More.getInstance();
			}

		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "";
		}

		@Override
		public int getCount() {
			return 3;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.home_LinearLayout:
			pager.setCurrentItem(0, false);
			break;
		case R.id.chat_LinearLayout:
			pager.setCurrentItem(1, false);
			break;

		case R.id.more_LinearLayout:
			pager.setCurrentItem(2, false);
			break;
		}

	}

	private void initViewPager() {
		pager = (MyViewPager) findViewById(R.id.pager);
		pager.setScanScroll(false);
		// pager.setOffscreenPageLimit(2);
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setCurrentItem(0, false);
		home_ImageView.setImageResource(R.drawable.home2);
		home_TextView
				.setTextColor(getResources().getColor(R.color.orange_text));
		home_View.setBackgroundResource(R.color.orange_text);
		home_View.setVisibility(View.VISIBLE);
		LinearLayout root = (LinearLayout) findViewById(R.id.root);

		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					home_ImageView.setImageResource(R.drawable.home2);
					home_TextView.setTextColor(getResources().getColor(
							R.color.orange_text));
					home_View.setBackgroundResource(R.color.orange_text);
					home_View.setVisibility(View.VISIBLE);
					chat_ImageView.setImageResource(R.drawable.message1);
					chat_Textview.setTextColor(getResources().getColor(
							R.color.gray_text));
					chat_View.setBackgroundResource(R.color.gray_text);
					chat_View.setVisibility(View.INVISIBLE);
					more_ImageView
							.setImageResource(R.drawable.navigationbar_more);
					more_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					more_View.setBackgroundResource(R.color.gray_text);
					more_View.setVisibility(View.INVISIBLE);
					break;
				case 1:
					home_ImageView.setImageResource(R.drawable.home1);
					home_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					home_View.setBackgroundResource(R.color.gray_text);
					home_View.setVisibility(View.INVISIBLE);
					chat_ImageView.setImageResource(R.drawable.message2);
					chat_Textview.setTextColor(getResources().getColor(
							R.color.orange_text));
					chat_View.setBackgroundResource(R.color.orange_text);
					chat_View.setVisibility(View.VISIBLE);
					more_ImageView
							.setImageResource(R.drawable.navigationbar_more);
					more_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					more_View.setBackgroundResource(R.color.gray_text);
					more_View.setVisibility(View.INVISIBLE);
					break;
				case 2:
					home_ImageView.setImageResource(R.drawable.home1);
					home_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					home_View.setBackgroundResource(R.color.gray_text);
					home_View.setVisibility(View.INVISIBLE);
					chat_ImageView.setImageResource(R.drawable.message1);
					chat_Textview.setTextColor(getResources().getColor(
							R.color.gray_text));
					chat_View.setBackgroundResource(R.color.gray_text);
					chat_View.setVisibility(View.INVISIBLE);
					more_ImageView
							.setImageResource(R.drawable.navigationbar_more_highlighted);
					more_TextView.setTextColor(getResources().getColor(
							R.color.orange_text));
					more_View.setBackgroundResource(R.color.orange_text);
					more_View.setVisibility(View.VISIBLE);
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * @Description: TODO(退出确认提示框)
	 * @author 诸葛飞扬。JJ
	 * @date 2015-1-2 上午9:20:01
	 */
	private void exitDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				Activity_Main.this);
		builder.setMessage("您确定退出吗？").setTitle("提示")
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						arg0.cancel();
					}
				})
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Activity_Main.this.finish();
						android.os.Process.killProcess(android.os.Process
								.myPid());
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitDialog();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		if (arg2 != null && arg1 == 889) {
			System.out.println("Activity Main 接收到result");
			Fragment_Home.getInstance().city_TextView.setText(arg2
					.getStringExtra("city"));
		}
	}

	float mTouchStartX;
	float mTouchStartY;
	private float x;
	private float y;

	@SuppressWarnings("deprecation")
	@Override
	public boolean onTouch(View v, MotionEvent event) {

		// 获取相对屏幕的坐标，即以屏幕左上角为原点
		x = event.getRawX();
		y = event.getRawY() - 25; // 25是系统状态栏的高度

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// 获取相对View的坐标，即以此View左上角为原点
			mTouchStartX = event.getX();
			mTouchStartY = event.getY();

			break;
		case MotionEvent.ACTION_MOVE:
			// 更新浮动窗口位置参数

			AbsoluteLayout.LayoutParams params = new AbsoluteLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
					(int) (x - mTouchStartX), (int) (y - mTouchStartY));
			lushui_ImageView.setLayoutParams(params);
			break;

		case MotionEvent.ACTION_UP:
			System.out.println((event.getX() - mTouchStartX)  + ":"
					+(event.getY() - mTouchStartY));
			if (((event.getX() - mTouchStartX) < 40 && (event.getY() - mTouchStartY) < 40)
					|| ((mTouchStartX - event.getX()) < 40 && (mTouchStartY - event
							.getY()) < 40)) {
				pager.setCurrentItem(1);
				return true;
			}
			// 更新浮动窗口位置参数
			AbsoluteLayout.LayoutParams params2 = new AbsoluteLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
					(int) (x - mTouchStartX), (int) (y - mTouchStartY));
			lushui_ImageView.setLayoutParams(params2);
			// 可以在此记录最后一次的位置

			mTouchStartX = mTouchStartY = 0;
			break;
		}
		return true;
	}
}
