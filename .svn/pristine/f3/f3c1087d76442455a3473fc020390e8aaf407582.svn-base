/**   
* 文件名：Fragment_Banner.java 
* 类名称：Fragment_Banner   
* 类描述：      
* 创建人：诸葛飞扬。JJ   
* 创建时间：2014-12-31 下午3:42:42  
* Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
* 版本信息：    
* 修改人：jj   
* 修改时间：2014-12-31 下午3:42:42   
* 修改备注：   
*/ 
package com.wanqin.ktv.main;

import org.json.JSONObject;

import com.wanqin.ktv.R;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * @ClassName: Fragment_Banner
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-12-31 下午3:42:42
 * 
 */
@SuppressLint("ValidFragment")
public class Fragment_Banner extends Fragment implements OnClickListener {
	private JSONObject jsonObject;
	private ImageView imageView;
	private Drawable drawable;
	
	
	
	/**
	 * @Description: TODO(演示用的构造方法)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-31 下午3:47:54
	 * @return
	 */
	public Fragment_Banner(Drawable drawable) {
		super();
		this.drawable = drawable;
	}

	public Fragment_Banner(JSONObject jsonObject) {
		super();
		this.jsonObject = jsonObject;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_banner, null);
		imageView=(ImageView) view.findViewById(R.id.imageView);
		imageView.setOnClickListener(this);
		imageView.setImageDrawable(drawable);
		return view;
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageView:
			
			break;

		}

	}

}
