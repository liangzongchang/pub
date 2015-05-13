/**   
 * 文件名：Activit_ShopMap.java 
 * 类名称：Activit_ShopMap   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2015-1-10 下午9:42:07  
 * Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2015-1-10 下午9:42:07   
 * 修改备注：   
 */
package com.wanqin.ktv.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.wanqin.ktv.R;
import com.wanqin.ktv.application.KTV_Application;

/**
 * @ClassName: Activit_ShopMap
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-10 下午9:42:07
 * 
 */
public class Activit_ShopMap extends SherlockActivity implements
		OnClickListener {

	private MapView MapView;
	private MapController mMapController;
	private ImageView left_Button;
	private ImageView right_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_shopmap);
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

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}
	private void initViews() {
		
		KTV_Application app = (KTV_Application) this.getApplication();
		if (app.mBMapManager == null) {
			app.mBMapManager = new BMapManager(getApplicationContext());
			/**
			 * 如果BMapManager没有初始化则初始化BMapManager
			 */
			app.mBMapManager.init(new KTV_Application.MyGeneralListener());
		}
		 MapView = (MapView)findViewById(R.id.mapView);
	        /**
	         * 获取地图控制器
	         */
	        mMapController = MapView.getController();
	        /**
	         *  设置地图是否响应点击事件  .
	         */
	        mMapController.enableClick(true);
	        /**
	         * 设置地图缩放级别
	         */
	        mMapController.setZoom(20);
	
	        mMapController.setCenter(new GeoPoint((int)(28.197237*1E6), (int)(112.980673*1E6)));
	        MapView.refresh();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			finish();
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			break;

		default:
			break;
		}

	}

}
