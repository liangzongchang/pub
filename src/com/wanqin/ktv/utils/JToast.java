/**   
 * 文件名：JToast.java 
 * 类名称：JToast   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-12-28 下午5:53:38  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-12-28 下午5:53:38   
 * 修改备注：   
 */
package com.wanqin.ktv.utils;

import android.content.Context;

import com.github.johnpersano.supertoasts.SuperToast;

/**
 * @ClassName: JToast
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-12-28 下午5:53:38
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
