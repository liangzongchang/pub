/**   
 * �ļ�����Fragment_RegInfo.java 
 * �����ƣ�Fragment_RegInfo   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2014-12-28 ����5:39:44  
 * Copyright �����JJ Corporation 2014 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2014-12-28 ����5:39:44   
 * �޸ı�ע��   
 */
package com.wanqin.ktv.reg;

import com.wanqin.ktv.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * @ClassName: Fragment_RegInfo
 * @Description: TODO(*)
 * @author �����JJ
 * @date 2014-12-28 ����5:39:44
 * 
 */
public class Fragment_RegInfo extends Fragment implements OnClickListener {
	public EditText username_EditText, nickName_EditText, pasword_EditText,
			confim_EditText, email_EditText, sponsor_EditText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_reginfo, null);
		username_EditText = (EditText) view
				.findViewById(R.id.username_EditText);
		nickName_EditText = (EditText) view
				.findViewById(R.id.nickName_EditText);
		pasword_EditText = (EditText) view.findViewById(R.id.pasword_EditText);
		confim_EditText = (EditText) view.findViewById(R.id.confim_EditText);
		email_EditText = (EditText) view.findViewById(R.id.email_EditText);
		sponsor_EditText = (EditText) view.findViewById(R.id.sponsor_EditText);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
