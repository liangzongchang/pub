/**   
 * 文件名：Fragment_Home.java 
 * 类名称：Fragment_Home   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-9-7 上午10:49:53  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-9-7 上午10:49:53   
 * 修改备注：   
 */
package com.wanqin.ktv.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wanqin.ktv.R;
import com.wanqin.ktv.shop.Activity_ShopList;
import com.wanqin.ktv.utils.HttpUtil;
import com.wanqin.ktv.utils.ImageUtil;
import com.wanqin.ktv.utils.JToast;
import com.wanqin.ktv.utils.ListViewItemHeightUtil;

/**
 * @ClassName: Fragment_Home
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-9-7 上午10:49:53
 * 
 */
public class Fragment_Home extends Fragment implements OnClickListener,
		OnPageChangeListener, PlatformActionListener {
	static Fragment_Home fragment_Home;
	public AutoScrollViewPager pager;
	/**
	 * @Fields imgNum : TODO(暂定显示四个滚动广告，实际数量由服务器传来的json数组内对象数量决定，imgNum为演示测试数据)
	 */
	public int imgNum = 4;
	private GoogleMusicAdapter mAdapter;
	private ViewGroup group;
	private ImageView[] tips;
	private RoundedImageView ktv_RoundedImageView, bar_RoundedImageView,
			pub_RoundedImageView;
	private LinearLayout ktv_LinearLayout, pub_LinearLayout, bar_LinearLayout,
			root, left_ActionBar_Button;
	private ImageView right_ActionBar_Button, search_ImageView;
	private TextView search_TextView;
	private PopWindown_Share popWindown_Share;
	private HorizontalScrollView horizontalScrollView;
	private ListView listView;
	public TextView city_TextView;
	ScrollView mScrollView;
	private LinearLayout views_LinearLayout, sign_LinearLayout;

	public synchronized static Fragment_Home getInstance() {
		if (fragment_Home == null) {
			fragment_Home = new Fragment_Home();
		}
		return fragment_Home;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("fragment_Home oncreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_home, null);
		pager = (AutoScrollViewPager) view.findViewById(R.id.pager);
		mAdapter = new GoogleMusicAdapter(this.getChildFragmentManager());
		pager.setAdapter(mAdapter);
		pager.setOnPageChangeListener(Fragment_Home.this);
		pager.setInterval(5000);
		// pager.startAutoScroll();
		pager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2
				% mAdapter.getCount());

		WindowManager wm = getActivity().getWindowManager();
		int width = wm.getDefaultDisplay().getWidth();
		ViewGroup.LayoutParams params = pager.getLayoutParams();
		params.height = width * 9 / 16;
		initTips(view, imgNum);
		initViews(view);
		return view;
	}

	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2015-1-1 下午9:24:28
	 * @param view
	 */
	private void initViews(View view) {

		views_LinearLayout = (LinearLayout) view
				.findViewById(R.id.views_LinearLayout);
		popWindown_Share = new PopWindown_Share(this);
		root = (LinearLayout) view.findViewById(R.id.root);
		left_ActionBar_Button = (LinearLayout) view
				.findViewById(R.id.left_ActionBar_Button);
		right_ActionBar_Button = (ImageView) view
				.findViewById(R.id.right_ActionBar_Button);
		search_TextView = (TextView) view.findViewById(R.id.search_TextView);
		search_ImageView = (ImageView) view.findViewById(R.id.search_ImageView);
		ktv_RoundedImageView = (RoundedImageView) view
				.findViewById(R.id.ktv_RoundedImageView);
		bar_RoundedImageView = (RoundedImageView) view
				.findViewById(R.id.bar_RoundedImageView);
		pub_RoundedImageView = (RoundedImageView) view
				.findViewById(R.id.pub_RoundedImageView);
		ktv_LinearLayout = (LinearLayout) view
				.findViewById(R.id.ktv_LinearLayout);
		pub_LinearLayout = (LinearLayout) view
				.findViewById(R.id.pub_LinearLayout);
		bar_LinearLayout = (LinearLayout) view
				.findViewById(R.id.bar_LinearLayout);
		ktv_LinearLayout.setOnClickListener(this);
		pub_LinearLayout.setOnClickListener(this);
		bar_LinearLayout.setOnClickListener(this);
		left_ActionBar_Button.setOnClickListener(this);
		right_ActionBar_Button.setOnClickListener(this);
		search_TextView.setOnClickListener(this);
		search_ImageView.setOnClickListener(this);
		listView = (ListView) view.findViewById(R.id.listView);
		listView.setAdapter(new Adapter_ListView(getActivity(), null));
		ListViewItemHeightUtil.setListViewHeightBasedOnChildren(listView);
		addViewsToHorizontalScrollView();
		sign_LinearLayout = (LinearLayout) view
				.findViewById(R.id.sign_LinearLayout);
		sign_LinearLayout.setOnClickListener(this);
		city_TextView = (TextView) view.findViewById(R.id.city_TextView);
		// /-------------计算图片高度---------------
		/*
		 * WindowManager wm = getActivity().getWindowManager(); int width =
		 * wm.getDefaultDisplay().getWidth(); FrameLayout
		 * ktv_FrameLayout=(FrameLayout)
		 * view.findViewById(R.id.ktv_FrameLayout); FrameLayout
		 * bar_FrameLayout=(FrameLayout)
		 * view.findViewById(R.id.bar_FrameLayout); FrameLayout
		 * pub_FrameLayout=(FrameLayout)
		 * view.findViewById(R.id.pub_FrameLayout); ViewGroup.LayoutParams
		 * params = ktv_FrameLayout.getLayoutParams(); params.height =
		 * ((width-ImageUtil.dip2px(getActivity(), 15))/3) * 16/9;
		 * 
		 * ktv_FrameLayout.setLayoutParams(params);
		 * pub_FrameLayout.setLayoutParams(params);
		 * bar_FrameLayout.setLayoutParams(params);
		 */
		// ---------------------------------------
	}

	/**
	 * @Description: TODO(动态添加子控件到横向滚动条)
	 * @author 诸葛飞扬。JJ
	 * @date 2015-1-2 下午9:26:30
	 */
	private void addViewsToHorizontalScrollView() {
		for (int i = 0; i < 8; i++) {
			RoundedImageView imageView = new RoundedImageView(getActivity());
			LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			imageView.setScaleType(ScaleType.CENTER);
			if (i == 0) {
				
				layoutParams.leftMargin = ImageUtil.dip2px(getActivity(), 5);
			}
			imageView.setImageResource(R.drawable.ic_wechat);

			layoutParams.rightMargin = ImageUtil.dip2px(getActivity(), 5);
			imageView.setLayoutParams(layoutParams);
			imageView.setBorderWidth(0f);
			imageView
					.setCornerRadius(ImageUtil.dip2px(getActivity(), 5) * 1.0f);
			views_LinearLayout.addView(imageView);

		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ktv_LinearLayout:
			Intent ktv = new Intent(getActivity(), Activity_ShopList.class);
			ktv.putExtra("type", 1);
			getActivity().startActivity(ktv);
			getActivity().overridePendingTransition(R.anim.push_up_in,
					R.anim.push_up_out);
			break;
		case R.id.pub_LinearLayout:
			Intent pub = new Intent(getActivity(), Activity_ShopList.class);
			pub.putExtra("type", 2);
			getActivity().startActivity(pub);
			getActivity().overridePendingTransition(R.anim.push_up_in,
					R.anim.push_up_out);
			break;
		case R.id.bar_LinearLayout:
			Intent bar = new Intent(getActivity(), Activity_ShopList.class);
			bar.putExtra("type", 3);
			getActivity().startActivity(bar);
			getActivity().overridePendingTransition(R.anim.push_up_in,
					R.anim.push_up_out);
			break;
		case R.id.right_ActionBar_Button:
			popWindown_Share.showAtLocation(root, Gravity.BOTTOM
					| Gravity.CENTER_HORIZONTAL, 0, 0);
			break;
		case R.id.left_ActionBar_Button:
			Intent intent_city = new Intent(getActivity(),
					Activity_SelectCity.class);
			startActivityForResult(intent_city, 88);
			getActivity().overridePendingTransition(R.anim.push_up_in,
					R.anim.push_up_out);
			break;
		case R.id.search_ImageView:
			Intent intent_search = new Intent(getActivity(),
					Activity_Search.class);
			startActivity(intent_search);
			getActivity().overridePendingTransition(R.anim.push_up_in,
					R.anim.push_up_out);
			break;
		case R.id.sign_LinearLayout:
			JToast.showToast(getActivity(), "恭喜您，获得了1积分");
			showStandardDialog(getActivity(), "系统消息", "分享可获得1积分，是否现在分享？");
			break;
		}

	}

	/**
	 * @Description: TODO(标准选择对话框)
	 * @author: 诸葛飞扬.JJ
	 * @date 2015-2-8 上午10:40:23
	 * @param context
	 * @throws
	 */
	private void showStandardDialog(Context context, String title,
			String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				popWindown_Share.showAtLocation(root, Gravity.BOTTOM
						| Gravity.CENTER_HORIZONTAL, 0, 0);
				dialog.dismiss();
				sign_LinearLayout.setVisibility(View.GONE);
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				sign_LinearLayout.setVisibility(View.GONE);
			}
		});
		builder.create().show();
	}

	public class GoogleMusicAdapter extends FragmentPagerAdapter {
		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Parcelable saveState() {
			return super.saveState();
		}

		@Override
		public Fragment getItem(int position) {

			position = (position) % imgNum;
			System.out.println(position);
			List<Drawable> drawables = new ArrayList<Drawable>();
			drawables.add(getResources().getDrawable(R.drawable.test1));
			drawables.add(getResources().getDrawable(R.drawable.test2));
			drawables.add(getResources().getDrawable(R.drawable.test3));
			drawables.add(getResources().getDrawable(R.drawable.test4));
			return new Fragment_Banner(drawables.get(position));
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "";
		}

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		setImageBackground(tips, arg0 % imgNum);

	}

	/**
	 * 设置选中的tip的背景
	 * 
	 * @param selectItems
	 */
	private void setImageBackground(ImageView[] tip, int selectItems) {
		for (int i = 0; i < tip.length; i++) {
			if (i == selectItems) {
				tip[i].setBackgroundResource(R.drawable.page_indicator_focuse);
			} else {
				tip[i].setBackgroundResource(R.drawable.page_indicator_focused);
			}
		}
	}

	public void initTips(View view, int num) {
		group = (ViewGroup) view.findViewById(R.id.viewGroup);
		tips = new ImageView[num];
		for (int i = 0; i < tips.length; i++) {

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					10, 10, 0);
			params.setMargins(10, 10, 10, 10);

			ImageView imageView = new ImageView(getActivity());
			imageView.setLayoutParams(params);

			tips[i] = imageView;
			if (i == 0) {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focuse);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			}
			group.addView(imageView);
		}
	}

	private String shareURL = "http://www.qq.com";
	private String shareContent = "测试分享";

	public void shareToPengyouquan() {

		ShareSDK.initSDK(getActivity());
		ShareParams sp = new ShareParams();
		sp.setText(shareContent);
		sp.setShareType(Platform.SHARE_WEBPAGE);
		sp.setUrl(shareURL);
		Platform weibo = ShareSDK.getPlatform(WechatMoments.NAME);
		weibo.setPlatformActionListener(this); // 设置分享事件回调
		// 执行图文分享
		weibo.share(sp);
	}

	public void shareToWeixin() {

		ShareSDK.initSDK(getActivity());
		ShareParams sp = new ShareParams();
		sp.setText(shareContent);
		sp.setShareType(Platform.SHARE_WEBPAGE);
		sp.setUrl(shareURL);
		// sp.setImagePath(MainActivity.TEST_IMAGE);
		Platform weibo = ShareSDK.getPlatform(Wechat.NAME);
		weibo.removeAccount();
		weibo.setPlatformActionListener(this); // 设置分享事件回调
		// 执行图文分享
		weibo.share(sp);
	}

	public void shareToQQ() {

		ShareSDK.initSDK(getActivity());
		ShareParams sp = new ShareParams();
		sp.setText(shareContent + "\n" + shareURL);
		Platform weibo = ShareSDK.getPlatform(QQ.NAME);
		weibo.setPlatformActionListener(this); // 设置分享事件回调
		// 执行图文分享
		weibo.share(sp);
	}

	public void shareToWeibo() {

		ShareSDK.initSDK(getActivity());
		ShareParams sp = new ShareParams();
		sp.setText(shareContent + "\n" + shareURL);
		Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
		weibo.setPlatformActionListener(this); // 设置分享事件回调
		// 执行图文分享
		weibo.share(sp);
	}

	@Override
	public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onError(Platform arg0, int arg1, Throwable arg2) {
		Message message = new Message();
		if (arg0.getName().equals(Wechat.NAME)
				|| arg0.getName().equals(WechatMoments.NAME)) {
			message.what = 0;
		}
		if (arg0.getName().equals(QQ.NAME)) {
			message.what = 1;
		}
		if (arg0.getName().equals(SinaWeibo.NAME)) {
			message.what = 2;
		}
		message.obj = arg2.getMessage();
		handler.sendMessage(message);

	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				JToast.showErrorToast(getActivity().getApplicationContext(),
						msg.obj == null ? "未安装微信" : msg.obj.toString());
				break;
			case 1:
				JToast.showErrorToast(getActivity().getApplicationContext(),
						msg.obj == null ? "未安装QQ" : msg.obj.toString());
				break;
			case 2:
				JToast.showErrorToast(getActivity().getApplicationContext(),
						msg.obj == null ? "未安装新浪微博" : msg.obj.toString());
				break;
			default:
				break;
			}
		};
	};

	@Override
	public void onCancel(Platform arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	private void initNetWork() {
		final String url = "http://www.qq.com";
		HttpUtil.get(url, new JsonHttpResponseHandler() {
			@Override
			public void onStart() {
				System.out.println(url);
			}

			@Override
			public void onFinish() {

			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					String responseBody, Throwable e) {
				JToast.showWarnToast(getActivity(), "请求网络数据失败");

			}

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONArray response) {
				System.out.println(response);

			}
		});

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 888 && data != null) {

		}
	}
}
