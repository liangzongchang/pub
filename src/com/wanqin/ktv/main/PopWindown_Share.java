/**   
 * �ļ�����PopWindown_Share.java 
 * �����ƣ�PopWindown_Share   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2014-10-29 ����4:36:31  
 * Copyright �����JJ Corporation 2014 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2014-10-29 ����4:36:31   
 * �޸ı�ע��   
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
 * @author �����JJ
 * @date 2014-10-29 ����4:36:31
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
		// ����SelectPicPopupWindow��View
		this.setContentView(mMenuView);
		// ����SelectPicPopupWindow��������Ŀ�
		this.setWidth(LayoutParams.MATCH_PARENT);
		// ����SelectPicPopupWindow��������ĸ�
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// ����SelectPicPopupWindow��������ɵ��
		this.setFocusable(true);
		// ����SelectPicPopupWindow�������嶯��Ч��
		this.setAnimationStyle(R.style.AnimBottom);
		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		// ����SelectPicPopupWindow��������ı���
		this.setBackgroundDrawable(dw);

		// mMenuView���OnTouchListener�����жϻ�ȡ����λ�������ѡ������������ٵ�����
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
