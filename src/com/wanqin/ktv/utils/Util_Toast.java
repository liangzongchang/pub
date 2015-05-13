/**   
* 文件名：ToastUtil.java 
* 类名称：ToastUtil   
* 类描述：      
* 创建人：诸葛飞扬。JJ   
* 创建时间：2014-9-2 下午10:09:39  
* Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
* 版本信息：    
* 修改人：jj   
* 修改时间：2014-9-2 下午10:09:39   
* 修改备注：   
*/ 
package com.wanqin.ktv.utils;

import android.content.Context;

/**
 * @ClassName: ToastUtil
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-9-2 下午10:09:39
 * 
 */
public class Util_Toast {
	public static void show_Exception_Json(Context context){
		JToast.showErrorToast(context, "Json格式异常");
	}
	
}
