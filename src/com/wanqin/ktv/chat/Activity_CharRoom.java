package com.wanqin.ktv.chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.wanqin.ktv.R;
import com.wanqin.ktv.customview.MyViewPager;
import com.wanqin.ktv.main.Fragment_Home;
import com.wanqin.ktv.main.Fragment_More;
import com.wanqin.ktv.supperclass.MyActivity;

public class Activity_CharRoom extends SherlockFragmentActivity implements OnClickListener {
	private ImageView left_Button;
	private ImageView right_Button;
	private LinearLayout home_LinearLayout, chat_LinearLayout,
			more_LinearLayout;
	private ImageView home_ImageView, chat_ImageView, more_ImageView,
			lushui_ImageView;
	private TextView home_TextView, chat_Textview, more_TextView;
	private View home_View, chat_View, more_View;
	private MyViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chatroom);
		initActionBar();
		initViews();
	}

	private void initActionBar() {
		LayoutInflater inflater = getLayoutInflater();
		View actionBarView = inflater.inflate(R.layout.actionbar_translate,
				null);
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
		TextView tttTextView = (TextView) actionBarView
				.findViewById(R.id.title_ActionBar);

		// tttTextView.setText("聊天大厅");

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
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
		initViewPager();
	}

	class GoogleMusicAdapter extends FragmentPagerAdapter {

		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {

				return new Fragment_ChatRoom();
			} else if (position == 1) {

				return new Fragment_Chat();
			} else if (position == 2) {

				return new Fragment_RankingList();
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

	private void initViewPager() {
		pager = (MyViewPager) findViewById(R.id.pager);
		pager.setScanScroll(false);
		// pager.setOffscreenPageLimit(2);
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setCurrentItem(0, false);
		home_ImageView.setImageResource(R.drawable.qunliao2);
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
					home_ImageView.setImageResource(R.drawable.qunliao2);
					home_TextView.setTextColor(getResources().getColor(
							R.color.orange_text));
					home_View.setBackgroundResource(R.color.orange_text);
					home_View.setVisibility(View.VISIBLE);
					chat_ImageView.setImageResource(R.drawable.siliao1);
					chat_Textview.setTextColor(getResources().getColor(
							R.color.gray_text));
					chat_View.setBackgroundResource(R.color.gray_text);
					chat_View.setVisibility(View.INVISIBLE);
					more_ImageView
							.setImageResource(R.drawable.mime1);
					more_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					more_View.setBackgroundResource(R.color.gray_text);
					more_View.setVisibility(View.INVISIBLE);
					break;
				case 1:
					home_ImageView.setImageResource(R.drawable.qunliao1);
					home_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					home_View.setBackgroundResource(R.color.gray_text);
					home_View.setVisibility(View.INVISIBLE);
					chat_ImageView.setImageResource(R.drawable.siliao2);
					chat_Textview.setTextColor(getResources().getColor(
							R.color.orange_text));
					chat_View.setBackgroundResource(R.color.orange_text);
					chat_View.setVisibility(View.VISIBLE);
					more_ImageView
							.setImageResource(R.drawable.mime1);
					more_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					more_View.setBackgroundResource(R.color.gray_text);
					more_View.setVisibility(View.INVISIBLE);
					break;
				case 2:
					home_ImageView.setImageResource(R.drawable.qunliao1);
					home_TextView.setTextColor(getResources().getColor(
							R.color.gray_text));
					home_View.setBackgroundResource(R.color.gray_text);
					home_View.setVisibility(View.INVISIBLE);
					chat_ImageView.setImageResource(R.drawable.siliao1);
					chat_Textview.setTextColor(getResources().getColor(
							R.color.gray_text));
					chat_View.setBackgroundResource(R.color.gray_text);
					chat_View.setVisibility(View.INVISIBLE);
					more_ImageView
							.setImageResource(R.drawable.mime2);
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			finish();
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_right_out);
			break;
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

}
