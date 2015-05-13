/**   
* 文件名：Activity_PicSingleShop.java 
* 类名称：Activity_PicSingleShop   
* 类描述：      
* 创建人：诸葛飞扬。JJ   
* 创建时间：2015-1-11 上午10:48:52  
* Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
* 版本信息：    
* 修改人：jj   
* 修改时间：2015-1-11 上午10:48:52   
* 修改备注：   
*/ 
package com.wanqin.ktv.shop;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;

/**
 * @ClassName: Activity_PicSingleShop
 * @Description: TODO(查看店铺平面图)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-11 上午10:48:52
 * 
 */
public class Activity_PicSingleShop extends SherlockActivity implements
		OnClickListener {
	private ImageView imageView;
	private PhotoViewAttacher mAttacher;
	private ImageView left_Button;
	private ImageView right_Button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.acitvity_picsingleshop);
		initViews();
	}
	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2015-1-11 上午10:52:58
	 */
	private void initViews() {
		imageView=(ImageView) findViewById(R.id.imageView);
		
		mAttacher = new PhotoViewAttacher(imageView);
		mAttacher.update();
		imageView.setImageResource(R.drawable.pingmiantu);
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

		tttTextView.setText("店铺平面图");

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
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
