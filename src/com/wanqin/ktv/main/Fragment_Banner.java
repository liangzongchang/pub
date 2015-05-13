/**   
* �ļ�����Fragment_Banner.java 
* �����ƣ�Fragment_Banner   
* ��������      
* �����ˣ������JJ   
* ����ʱ�䣺2014-12-31 ����3:42:42  
* Copyright �����JJ Corporation 2014 ��Ȩ����     
* �汾��Ϣ��    
* �޸��ˣ�jj   
* �޸�ʱ�䣺2014-12-31 ����3:42:42   
* �޸ı�ע��   
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
 * @author �����JJ
 * @date 2014-12-31 ����3:42:42
 * 
 */
@SuppressLint("ValidFragment")
public class Fragment_Banner extends Fragment implements OnClickListener {
	private JSONObject jsonObject;
	private ImageView imageView;
	private Drawable drawable;
	
	
	
	/**
	 * @Description: TODO(��ʾ�õĹ��췽��)
	 * @author �����JJ
	 * @date 2014-12-31 ����3:47:54
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
