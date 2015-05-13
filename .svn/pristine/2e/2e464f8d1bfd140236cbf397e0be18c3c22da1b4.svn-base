/**   
 * 文件名：StringUtil.java 
 * 类名称：StringUtil   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-7-18 上午10:05:54  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-7-18 上午10:05:54   
 * 修改备注：   
 */
package com.wanqin.ktv.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: StringUtil
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-7-18 上午10:05:54
 * 
 */
public class StringUtil {
	// 判断手机号码格式是否正确
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(14[0-9])|(17[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);

		return m.matches();
	}

	// 判断email格式是否正确
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);

		return m.matches();
	}
}
