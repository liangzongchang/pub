/**   
 * �ļ�����MyJsonResponseHandler.java 
 * �����ƣ�MyJsonResponseHandler   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2014-9-10 ����10:18:39  
 * Copyright �����JJ Corporation 2014 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2014-9-10 ����10:18:39   
 * �޸ı�ע��   
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
 * @author �����JJ
 * @date 2014-9-10 ����10:18:39
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
		System.out.println("��������" + url);
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
			JToast.showErrorToast(context, "�����ַ������");
			break;

		case 500:
			JToast.showErrorToast(context, "�����������ڲ������������Ա��ϵ!");
			break;
		default:
			JToast.showWarnToast(context, "���ʷ�����ʧ�ܣ����Ժ����ԡ�����");
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
						if (info.contains("loginout") || info.contains("�Ự��ʱ")) {
							Intent intent = new Intent(context,
									Activity_Login.class);
							context.startActivity(intent);
							context.overridePendingTransition(
									R.anim.push_left_in, R.anim.push_left_out);
							context.finish();
						}
						if (info.contains("�ϴ�ʧ��")) {
							onUploadFail();
						}
					} else {
						JToast.showErrorToast(context, "�������ܾ�����������");
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
	 * @Description: TODO(������֤ͨ����ִ��)
	 * @author �����JJ
	 * @date 2014-9-4 ����8:54:51
	 * @param jsonObject
	 */
	public void onExecute(JSONObject response) {
		// TODO Auto-generated method stub

	}

	public void onExecute(JSONArray response) {
		// TODO Auto-generated method stub

	}
}