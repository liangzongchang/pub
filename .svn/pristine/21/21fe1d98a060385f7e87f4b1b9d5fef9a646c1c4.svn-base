/**   
 * 文件名：Activity_ShopList.java 
 * 类名称：Activity_ShopList   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2015-1-10 下午8:29:46  
 * Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2015-1-10 下午8:29:46   
 * 修改备注：   
 */
package com.wanqin.ktv.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;

/**
 * @ClassName: Activity_ShopList
 * @Description: TODO(店铺列表界面)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-10 下午8:29:46
 * 
 */
public class Activity_ShopList extends SherlockActivity implements
		OnClickListener {
	private ListView shops_ListView;
	private ImageView left_Button;
	private ImageView right_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shoplist);
		initActionBar();
		initViews();
	}

	private void initViews() {
		shops_ListView = (ListView) findViewById(R.id.shops_ListView);
		shops_ListView.setAdapter(new Adapter_Shops());
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

		tttTextView.setText("KTV");

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
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

	class Adapter_Shops extends BaseAdapter {

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
			view = LayoutInflater.from(Activity_ShopList.this).inflate(
					R.layout.item_listview_shops, null);
			final TextView shopName_TextView = (TextView) view
					.findViewById(R.id.shopName_TextView);
			final TextView details_TextView = (TextView) view
					.findViewById(R.id.details_TextView);
			switch (getIntent().getIntExtra("type", 1)) {
			case 1:
				shopName_TextView.setText("好乐迪KTV" + (position + 1) + "号店");
				break;

			case 2:
				shopName_TextView.setText("玛尔斯清吧" + (position + 1) + "号店");
				details_TextView
						.setText("鸡尾酒很有特色，店类的风格也是比较好的，很适合平时和朋友聚聚会、聊聊天什么的。娱乐的东西比较多，桌游什么的都有。");
				break;
			case 3:
				shopName_TextView.setText("魅力四射酒吧" + (position + 1) + "号店");
				details_TextView
						.setText("随着台上MC激情的声音走进魅力四射酒吧,迷离恍惚的灯光下，一张张忽明忽暗的年轻的2001年12月，当酒吧业在长沙风靡之时，长沙解放西路这条响当当的“酒吧一条街”上，一家名为“魅力四射”的酒吧正式开业，名字最初来源于国外一部关于酒吧的电影，电影的名字就叫“魅力四射”。在短短两个月内，“魅力四射”就以其独创性和互动性征服了广大玩家，其表演方式、操作水准和布台布景在长沙整个酒吧行业都处于领先地位。");
				break;
			}
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(Activity_ShopList.this,
							Activity_ShopSingle.class);
					intent.putExtra("title", shopName_TextView.getText()
							.toString());
					Activity_ShopList.this.startActivity(intent);
					Activity_ShopList.this.overridePendingTransition(
							R.anim.push_left_in, R.anim.push_left_out);
				}
			});
			return view;
		}

	}
}
