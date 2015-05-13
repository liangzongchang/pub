package com.wanqin.ktv.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wanqin.ktv.R;
import com.wanqin.ktv.customview.MyViewPager;
import com.wanqin.ktv.main.Fragment_More;

public class Fragment_Public_Chatroom extends Fragment implements
		OnClickListener {
	private ImageView left_Button;
	private ImageView right_Button;
	private LinearLayout home_LinearLayout, chat_LinearLayout,
			more_LinearLayout;
	private ImageView home_ImageView, chat_ImageView, more_ImageView,
			lushui_ImageView;
	private TextView home_TextView, chat_Textview, more_TextView;
	private View home_View, chat_View, more_View;
	private MyViewPager pager;
	private static Fragment_Public_Chatroom fragment_Public_Chatroom;
	public static Fragment_Public_Chatroom getInstance(){
		if (fragment_Public_Chatroom==null) {
			fragment_Public_Chatroom=new Fragment_Public_Chatroom();
		}
		return fragment_Public_Chatroom;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		return initViews(inflater);
	}
	private View initViews(LayoutInflater inflater) {
		View view=inflater.inflate(R.layout.activity_chatroom, null);
		home_LinearLayout = (LinearLayout) view.findViewById(R.id.home_LinearLayout);
		chat_LinearLayout = (LinearLayout) view.findViewById(R.id.chat_LinearLayout);
		more_LinearLayout = (LinearLayout) view.findViewById(R.id.more_LinearLayout);
		home_LinearLayout.setOnClickListener(this);
		chat_LinearLayout.setOnClickListener(this);
		more_LinearLayout.setOnClickListener(this);
		home_ImageView = (ImageView) view.findViewById(R.id.home_ImageView);
		chat_ImageView = (ImageView) view.findViewById(R.id.chat_ImageView);
		more_ImageView = (ImageView) view.findViewById(R.id.more_ImageView);
		home_TextView = (TextView) view.findViewById(R.id.home_TextView);
		chat_Textview = (TextView) view.findViewById(R.id.chat_Textview);
		more_TextView = (TextView) view.findViewById(R.id.more_TextView);

		home_View = view.findViewById(R.id.home_View);
		chat_View = view.findViewById(R.id.chat_View);
		more_View = view.findViewById(R.id.more_View);
		initViewPager(view);
		return view;
	}
	class GoogleMusicAdapter extends FragmentPagerAdapter {

		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {

				return Fragment_ChatRoom.getInstance();
			} else if (position == 1) {

				return Fragment_Chat.getInstance();
			} else if (position == 2) {

				return Fragment_RankingList.getInstance();
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

	private void initViewPager(View view) {
		pager = (MyViewPager) view.findViewById(R.id.pager);
		pager.setScanScroll(false);
		// pager.setOffscreenPageLimit(2);
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getChildFragmentManager());
		pager.setAdapter(adapter);
		pager.setCurrentItem(0, false);
		home_ImageView.setImageResource(R.drawable.qunliao2);
		home_TextView
				.setTextColor(getResources().getColor(R.color.orange_text));
		home_View.setBackgroundResource(R.color.orange_text);
		home_View.setVisibility(View.VISIBLE);
		LinearLayout root = (LinearLayout) view.findViewById(R.id.root);

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
