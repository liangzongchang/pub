/**   
* �ļ�����Fragment_validate.java 
* �����ƣ�Fragment_validate   
* ��������      
* �����ˣ������JJ   
* ����ʱ�䣺2014-12-28 ����5:38:58  
* Copyright �����JJ Corporation 2014 ��Ȩ����     
* �汾��Ϣ��    
* �޸��ˣ�jj   
* �޸�ʱ�䣺2014-12-28 ����5:38:58   
* �޸ı�ע��   
*/ 
package com.wanqin.ktv.reg;

import com.wanqin.ktv.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @ClassName: Fragment_validate
 * @Description: TODO(*)
 * @author �����JJ
 * @date 2014-12-28 ����5:38:58
 * 
 */
public class Fragment_validate extends Fragment {
	public TextView phoneNum_TextView,randomCode_TextView;
	public EditText randomCode_EditText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_validate, null);
		phoneNum_TextView=(TextView) view.findViewById(R.id.phoneNum_TextView);
		randomCode_EditText=(EditText) view.findViewById(R.id.randomCode_EditText);
		randomCode_TextView=(TextView) view.findViewById(R.id.randomCode_TextView);
		return view;
	}
}
