/**   
 * 文件名：Activity_Reg.java 
 * 类名称：Activity_Reg   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-12-28 上午9:59:44  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-12-28 上午9:59:44   
 * 修改备注：   
 */
package com.wanqin.ktv.reg;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.SMSSDK.VerifyCodeReadListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.wanqin.ktv.R;
import com.wanqin.ktv.application.KTV_Application;
import com.wanqin.ktv.login.Activity_Login;
import com.wanqin.ktv.utils.HttpUtil;
import com.wanqin.ktv.utils.JToast;
import com.wanqin.ktv.utils.MyJsonResponseHandler;
import com.wanqin.ktv.utils.StringUtil;

/**
 * @ClassName: Activity_Reg
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-12-28 上午9:59:44
 * 
 */
public class Activity_Reg extends SherlockFragmentActivity implements
		OnClickListener {
	private EditText phone_EditText, randomCode_EditText, pasword_EditText,
			confim_EditText, sponsor_EditText;
	private Button right_Button, get_Button, reg_Button;
	private ImageView left_Button;
	private TextView tttTextView;
	private ViewPager pager;
	private Fragment_PhoneNum fragment_PhoneNum;
	private Fragment_RegInfo fragment_RegInfo;
	private Fragment_validate fragment_validate;
	private boolean ready = false;
	private String phone = "", code = "";
	private Timer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);

		initSMSSDK();
		initRecever();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		initActionBar();
		initView();
		//initNetWork_getSponsor();
	}

	/**
	 * @Description: TODO(设置短信监听)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 下午9:50:37
	 */
	SMSReceiver smsReceiver;
	VerifyCodeReadListener verifyCodeReadListener = new VerifyCodeReadListener() {

		@Override
		public void onReadVerifyCode(String arg0) {
			System.out.println("接收到的验证码是:" + arg0);
			randomCode_EditText.setText(arg0);

		}
	};

	private void initRecever() {

		smsReceiver = new SMSReceiver(verifyCodeReadListener);
		IntentFilter intentFilter = new IntentFilter(
				"android.provider.Telephony.SMS_RECEIVED");
		intentFilter.setPriority(1000);
		registerReceiver(smsReceiver, intentFilter);

	}

	/**
	 * @Fields smsValidate : TODO(短信验证结果)
	 */
	private boolean smsValidate = false;

	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 下午6:47:59
	 */
	private void initSMSSDK() {
		SMSSDK.initSDK(this, getString(R.string.APPKEY),
				getString(R.string.APPSECRET));
		EventHandler eventHandler = new EventHandler() {
			public void afterEvent(final int event, final int result,
					final Object data) {
				Activity_Reg.this.runOnUiThread(new Runnable() {

					@Override
					public void run() {
						if (result == SMSSDK.RESULT_COMPLETE) {
							// 回调完成
							if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
								// 提交验证码成功
								submitReg();

							} else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
								// 获取验证码成功
							} else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
								// 返回支持发送验证码的国家列表
							}
						} else {
							if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
								JToast.showErrorToast(getApplicationContext(),
										"验证码错误");
								progressDialog.dismiss();

							} else {
								JToast.showToast(getApplicationContext(),
										data.toString());
								((Throwable) data).printStackTrace();

							}

						}

					}
				});

			}
		};
		// 注册回调监听接口
		SMSSDK.registerEventHandler(eventHandler);
		ready = true;
	}

	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 下午5:08:14
	 */
	private void initView() {
		pasword_EditText = (EditText) findViewById(R.id.pasword_EditText);
		confim_EditText = (EditText) findViewById(R.id.confim_EditText);
		phone_EditText = (EditText) findViewById(R.id.phone_EditText);
		sponsor_EditText = (EditText) findViewById(R.id.sponsor_EditText);
		randomCode_EditText = (EditText) findViewById(R.id.randomCode_EditText);
		get_Button = (Button) findViewById(R.id.get_Button);
		get_Button.setOnClickListener(this);
		reg_Button = (Button) findViewById(R.id.reg_Button);
		reg_Button.setOnClickListener(this);
		fragment_PhoneNum = new Fragment_PhoneNum();
		fragment_validate = new Fragment_validate();
		fragment_RegInfo = new Fragment_RegInfo();
		pager = (ViewPager) findViewById(R.id.pager);
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setCurrentItem(0);
		pager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return true;
			}
		});
	}

	private static String[] CONTENT = { "基本信息", "详细信息", "专家点评" };

	class GoogleMusicAdapter extends FragmentPagerAdapter {

		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {

				return fragment_PhoneNum;
			} else if (position == 1) {

				return fragment_validate;
			} else if (position == 2) {

				return fragment_RegInfo;
			} else {
				return new Fragment_PhoneNum();
			}

		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position].toUpperCase();
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}
	}

	/**
	 * @Description: TODO(初始化Actionbar)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 上午10:17:20
	 */
	private void initActionBar() {

		LayoutInflater inflater = getLayoutInflater();
		View actionBarView = inflater.inflate(R.layout.actionbar_button, null);
		actionBarView.setOnClickListener(this);
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.transparent));
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setHomeButtonEnabled(false);
		getSupportActionBar().setLogo(R.drawable.ic_launcher);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		// getSupportActionBar().setTitle("网易新闻");
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		getSupportActionBar().setCustomView(actionBarView);
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		left_Button = (ImageView) actionBarView
				.findViewById(R.id.left_ActionBar_Button);
		left_Button.setImageResource(R.drawable.selector_back);
		left_Button.setOnClickListener(this);
		left_Button.setVisibility(View.VISIBLE);
		tttTextView = (TextView) actionBarView
				.findViewById(R.id.title_ActionBar);

		tttTextView.setText("会员注册");

		right_Button = (Button) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.get_Button:
			sendRandomCode();
			break;
		case R.id.reg_Button:
			validateRandomCode();

			break;
		case R.id.left_ActionBar_Button:
			int i = pager.getCurrentItem();
			switch (i) {
			case 0:
				finish();
				overridePendingTransition(R.anim.push_right_in,
						R.anim.push_right_out);
				break;

			case 1:
				pager.setCurrentItem(0);

				break;
			case 2:
				pager.setCurrentItem(1);

				break;
			}

			break;

		case R.id.right_ActionBar_Button:
			switch (pager.getCurrentItem()) {
			case 0:
				sendRandomCode();
				break;

			case 1:

				break;

			case 2:

				break;
			}
			break;

		}

	}

	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-29 下午9:42:47
	 */
	private void submitReg() {
		if (validateReg()) {
			//initNetWork_submitReg();
			Intent intent = new Intent(Activity_Reg.this,
					Activity_Login.class);
			intent.putExtra("username", phone_EditText.getText().toString()
					.trim());
			intent.putExtra("password", pasword_EditText.getText()
					.toString().trim());
			setResult(OK, intent);
			progressDialog.dismiss();
			finish();
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_right_out);
		}

	}

	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-29 下午9:49:17
	 */
	private void initNetWork_submitReg() {
		String url = "http://120.24.238.250:9999/kpub/member_register.pub?memberPhone="
				+ phone
				+ "&memberCiphertext="
				+ pasword_EditText.getText().toString()
				+ "&referrerNo="
				+ sponsor_EditText.getText().toString();
		HttpUtil.get(url, new MyJsonResponseHandler(url, this,
				KTV_Application.CHARSET) {

			@Override
			public void onExecute(JSONObject response) {
				Intent intent = new Intent(Activity_Reg.this,
						Activity_Login.class);
				intent.putExtra("username", phone_EditText.getText().toString()
						.trim());
				intent.putExtra("password", pasword_EditText.getText()
						.toString().trim());
				setResult(OK, intent);
				progressDialog.dismiss();
				finish();
				overridePendingTransition(R.anim.push_right_in,
						R.anim.push_right_out);
			}
		});

	}

	final static int OK = 61;

	private void initNetWork_getSponsor() {
		String url = "http://120.24.238.250:9999/kpub/member_getRefererNo.pub";
		HttpUtil.get(url, new MyJsonResponseHandler(url, this,
				KTV_Application.CHARSET) {

			@Override
			public void onExecute(JSONObject response) {
				try {
					sponsor_EditText.setText(response.getString("referrer_no"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JToast.showWarnToast(getApplicationContext(), "服务器返回数据异常");
				}
			}
		});
	}

	/**
	 * @Description: TODO(验证注册信息)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-29 下午9:43:05
	 * @return
	 */
	private boolean validateReg() {

		if (pasword_EditText.getText().toString().trim().equals("")) {
			JToast.showErrorToast(getApplicationContext(), "请输入密码");
			return false;
		}
		if (confim_EditText.getText().toString().trim().equals("")) {
			JToast.showErrorToast(getApplicationContext(), "请输入确认密码");
			return false;
		}
		if (!confim_EditText.getText().toString().trim()
				.equals(pasword_EditText.getText().toString().trim())) {
			JToast.showErrorToast(getApplicationContext(), "两次输入密码不一致");
			return false;
		}
		if (sponsor_EditText.getText().toString().trim().equals("")) {
			JToast.showErrorToast(getApplicationContext(), "请输入推荐人");
			return false;
		}
		return true;
	}

	/**
	 * @Description: TODO(验证短信验证码)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 下午8:51:17
	 */
	private void validateRandomCode() {
		if (randomCode_EditText.getText().toString().trim().equals("")) {
			JToast.showErrorToast(getApplicationContext(), "请输入验证码");
			return;
		}
		code = randomCode_EditText.getText().toString().trim();
		initProgressDialog();
	}

	private ProgressDialog progressDialog;

	/**
	 * @Description: TODO(初始化进度对话框)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 下午8:59:58
	 */
	private void initProgressDialog() {
		progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("请稍后···");
		progressDialog.show();
		SMSSDK.submitVerificationCode("86", phone, code);

	}

	/**
	 * @Description: TODO(发送验证码)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 下午6:12:19
	 */
	private void sendRandomCode() {
		if (time > 0) {
			JToast.showErrorToast(getApplicationContext(), "两次获取验证码的间隔不能小于60秒");
			return;
		}
		get_Button.setTextSize(15);
		if (phone_EditText.getText().toString().trim().equals("")) {
			JToast.showErrorToast(getApplicationContext(), "请输入手机号码");
			return;
		}
		if (StringUtil.isMobileNO(phone_EditText.getText().toString().trim())) {
			SMSSDK.getVerificationCode("86", phone_EditText.getText()
					.toString().trim());
			phone = phone_EditText.getText().toString().trim();
			pager.setCurrentItem(1);
			time = 60;
			timer = new Timer(true);
			timerTask = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while (time > 0) {
						try {
							Thread.currentThread().sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Activity_Reg.this.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								String text = "<font color=\"#FF0000\">" + time
										+ "</font>" + "秒后重新发送";
								get_Button.setText(Html.fromHtml(text));
								if (time == 0) {
									get_Button.setText(Html
											.fromHtml("<font color=\"#FF0000\">"
													+ "收不到验证码?" + "</font>"));
									timerTask.cancel();
									timer.cancel();
									get_Button
											.setOnClickListener(new OnClickListener() {

												@Override
												public void onClick(View v) {
													// TODO
													// Auto-generated
													// method stub
													JToast.showToast(
															getApplicationContext(),
															"正在重新获取短信验证码");
													sendRandomCode();

												}
											});
								}
								time--;
							}
						});

					}

				}
			};
			timer.schedule(timerTask, 0);
		} else {
			JToast.showErrorToast(getApplicationContext(), "手机号输入有误，请输入正确的手机号码");
		}

	}

	int time = 0;
	private TimerTask timerTask;

	@Override
	protected void onDestroy() {
		if (ready) {
			// 销毁回调监听接口
			SMSSDK.unregisterAllEventHandler();
		}
		if (timer != null) {
			timer.cancel();
		}
		if (timerTask != null) {
			timerTask.cancel();
		}
		unregisterReceiver(smsReceiver);
		super.onDestroy();
	}

}
