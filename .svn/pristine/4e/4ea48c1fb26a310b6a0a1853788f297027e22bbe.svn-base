/**   
 * 文件名：PopWindown_Share.java 
 * 类名称：PopWindown_Share   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-10-29 下午4:36:31  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-10-29 下午4:36:31   
 * 修改备注：   
 */
package com.wanqin.ktv.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.wanqin.ktv.R;



/**
 * @ClassName: PopWindown_Share
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-10-29 下午4:36:31
 * 
 */
public class PopWindown_Share extends PopupWindow implements OnClickListener {
	private Fragment_Home context;
	private View mMenuView;
	private ImageView pengyouquan, weixin, qq, youjian;

	public PopWindown_Share(Fragment_Home activity_Main) {

		this.context = activity_Main;
		LayoutInflater inflater = (LayoutInflater) context.getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.popwindown_share,
				null);
		// 设置SelectPicPopupWindow的View
		this.setContentView(mMenuView);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(LayoutParams.MATCH_PARENT);
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		// 设置SelectPicPopupWindow弹出窗体动画效果
		this.setAnimationStyle(R.style.AnimBottom);
		// 实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		// 设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);

		// mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
		mMenuView.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {

				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {

						dismiss();
					}
				}
				return true;
			}
		});
		pengyouquan = (ImageView) mMenuView.findViewById(R.id.pengyouquan);
		weixin = (ImageView) mMenuView.findViewById(R.id.weixin);
		qq = (ImageView) mMenuView.findViewById(R.id.qq);
		youjian = (ImageView) mMenuView.findViewById(R.id.youjian);
		pengyouquan.setOnClickListener(this);
		weixin.setOnClickListener(this);
		qq.setOnClickListener(this);
		youjian.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pengyouquan:
			context.shareToPengyouquan();
			this.dismiss();
			break;

		case R.id.weixin:
			context.shareToWeixin();
			this.dismiss();
			break;
		case R.id.qq:
			context.shareToQQ();
			this.dismiss();
			break;
		case R.id.youjian:
			context.shareToWeibo();
			this.dismiss();
			break;
		}

	}

}
