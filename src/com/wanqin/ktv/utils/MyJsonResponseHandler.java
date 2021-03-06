/**   
 * 文件名：MyJsonResponseHandler.java 
 * 类名称：MyJsonResponseHandler   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-9-10 上午10:18:39  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-9-10 上午10:18:39   
 * 修改备注：   
 */
package com.wanqin.ktv.utils;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;

import com.jj.common.util.Util_JProgressDialog;
import com.jj.common.view.JProgressDialog;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.wanqin.ktv.R;
import com.wanqin.ktv.login.Activity_Login;

/**
 * @ClassName: MyJsonResponseHandler
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-9-10 上午10:18:39
 * 
 */
public class MyJsonResponseHandler extends JsonHttpResponseHandler {
	String url;
	Activity context;
	JProgressDialog progressDialog;
	boolean allowProgressDialog = true;

	public MyJsonResponseHandler(String url, Activity context, String charSet) {
		super(charSet);
		this.url = url;
		this.context = context;
		progressDialog = JProgressDialog.createDialog(context);
	}

	public MyJsonResponseHandler(String url, Activity context, String charSet,
			boolean allowProgressDialog) {
		super(charSet);
		this.url = url;
		this.context = context;
		if (context != null) {
			progressDialog = JProgressDialog.createDialog(context);
		}

		this.allowProgressDialog = allowProgressDialog;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("请求网络" + url);
		if (allowProgressDialog) {
			Util_JProgressDialog.start(progressDialog, context);
		}

	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		super.onFinish();
		if (allowProgressDialog) {
			Util_JProgressDialog.stop(progressDialog, context);
		}

	}

	@Override
	public void onFailure(int statusCode, Header[] headers,
			String responseBody, Throwable e) {
		// TODO Auto-generated method stub
		if (allowProgressDialog) {
			Util_JProgressDialog.stop(progressDialog, context);
		}
		switch (statusCode) {
		case 404:
			JToast.showErrorToast(context, "请求地址不存在");
			break;

		case 500:
			JToast.showErrorToast(context, "服务器发生内部错误，请与管理员联系!");
			break;
		default:
			JToast.showWarnToast(context, "访问服务器失败，请稍后重试···");
			break;

		}
		
	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
		// TODO Auto-generated method stub
		super.onSuccess(statusCode, headers, response);
		try {
			System.out.println(response);
			if (!response.getJSONObject("head").isNull("status")) {

				if (!response.getJSONObject("head").isNull("info")) {
					onHeadData(response.getJSONObject("head").getInt("status"),
							response.getJSONObject("head").getString("info"));
				}

				if (response.getJSONObject("head").getInt("status") == 0
						&& !response.getJSONObject("head").isNull("info")) {
					String info = response.getJSONObject("head").getString(
							"info");
					if (info != null) {

						JToast.showWarnToast(context.getApplicationContext(),
								info);
						if (info.contains("loginout") || info.contains("会话超时")) {
							Intent intent = new Intent(context,
									Activity_Login.class);
							context.startActivity(intent);
							context.overridePendingTransition(
									R.anim.push_left_in, R.anim.push_left_out);
							context.finish();
						}
						if (info.contains("上传失败")) {
							onUploadFail();
						}
					} else {
						JToast.showErrorToast(context, "服务器拒绝了您的请求");
					}

				} else {
					try {
						if (response.get("data") instanceof JSONObject) {
							onExecute(response.getJSONObject("data"));
						} else if (response.get("data") instanceof JSONArray) {
							onExecute(response.getJSONArray("data"));
						}
					} catch (Exception e) {
						onExecute(new JSONObject());
					}

				}
			} else {
				onExecute(response);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Util_Toast.show_Exception_Json(context.getApplicationContext());
			e.printStackTrace();
		}
	}

	public void onUploadFail() {
		// TODO Auto-generated method stub

	}

	public void onHeadData(int status, String info) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
		onExecute(response);
	}

	/**
	 * @Description: TODO(所有验证通过后执行)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-9-4 上午8:54:51
	 * @param jsonObject
	 */
	public void onExecute(JSONObject response) {
		// TODO Auto-generated method stub

	}

	public void onExecute(JSONArray response) {
		// TODO Auto-generated method stub

	}
}
