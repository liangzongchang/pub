/**   
 * �ļ�����JToast.java 
 * �����ƣ�JToast   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2014-12-28 ����5:53:38  
 * Copyright �����JJ Corporation 2014 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2014-12-28 ����5:53:38   
 * �޸ı�ע��   
 */
package com.wanqin.ktv.utils;

import android.content.Context;

import com.github.johnpersano.supertoasts.SuperToast;

/**
 * @ClassName: JToast
 * @Description: TODO(*)
 * @author �����JJ
 * @date 2014-12-28 ����5:53:38
 * 
 */
public class JToast {
	public static void showToast(Context context,String  info) {
		SuperToast superToast = new SuperToast(context);
        superToast.setText(info);
        superToast.setDuration(SuperToast.Duration.MEDIUM);
        superToast.setAnimations(SuperToast.Animations.FLYIN);
        superToast.setBackground(SuperToast.Background.BLUE);
        superToast.show();
	}

	public static void showErrorToast(Context context,String  info) {
		
		SuperToast superToast = new SuperToast(context);
        superToast.setText(info);
        superToast.setDuration(SuperToast.Duration.MEDIUM);
        superToast.setAnimations(SuperToast.Animations.FLYIN);
        superToast.setBackground(SuperToast.Background.RED);
        superToast.show();
	}

	public static void showWarnToast(Context context,String  info) {
		SuperToast superToast = new SuperToast(context);
        superToast.setText(info);
        superToast.setDuration(SuperToast.Duration.MEDIUM);
        superToast.setAnimations(SuperToast.Animations.FLYIN);
        superToast.setBackground(SuperToast.Background.ORANGE);
        superToast.show();
	}
}
