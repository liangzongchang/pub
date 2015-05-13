/**   
 * 文件名：Fragment_Mine.java 
 * 类名称：Fragment_Mine   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-9-7 上午10:51:03  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-9-7 上午10:51:03   
 * 修改备注：   
 */
package com.wanqin.ktv.person;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockFragment;
import com.wanqin.ktv.R;
import com.wanqin.ktv.shop.Activity_OrderConfim;
import com.wanqin.ktv.utils.ImageUtil;

/**
 * @ClassName: Fragment_Mine
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-9-7 上午10:51:03
 * 
 */
public class Fragment_Mine extends SherlockFragment implements OnClickListener {
	private static Fragment_Mine fragment_Mine;
	private LinearLayout person_LinearLayout, integral_LinearLayout,
			order_LinearLayout;

	public synchronized static Fragment_Mine getInstance() {
		if (fragment_Mine == null) {
			fragment_Mine = new Fragment_Mine();
		}
		return fragment_Mine;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_mine, null);
		initViews(view);
		return view;
	}

	private void initViews(View view) {
		LinearLayout root = (LinearLayout) view.findViewById(R.id.root);
		LayoutParams params = root.getLayoutParams();
		WindowManager wm = getActivity().getWindowManager();
		int height = wm.getDefaultDisplay().getHeight();
		params.height = (height - ImageUtil.dip2px(getSherlockActivity(), 100)) / 2;
		root.setLayoutParams(params);
		person_LinearLayout = (LinearLayout) view
				.findViewById(R.id.person_LinearLayout);
		integral_LinearLayout = (LinearLayout) view
				.findViewById(R.id.integral_LinearLayout);
		order_LinearLayout = (LinearLayout) view
				.findViewById(R.id.order_LinearLayout);
		person_LinearLayout.setOnClickListener(this);
		integral_LinearLayout.setOnClickListener(this);
		order_LinearLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.person_LinearLayout:
			Intent intent=new Intent(getActivity(), Activity_PersonCenter.class);
			getActivity().startActivity(intent);
			getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;

		case R.id.integral_LinearLayout:
			Intent intent1=new Intent(getActivity(), Activity_MyScore.class);
			getActivity().startActivity(intent1);
			getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		case R.id.order_LinearLayout:
			Intent intent2=new Intent(getActivity(), Activity_MyOrder.class);
			getActivity().startActivity(intent2);
			getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
	}
}
