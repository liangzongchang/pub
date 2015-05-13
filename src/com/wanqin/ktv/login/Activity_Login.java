package com.wanqin.ktv.login;

import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Process;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;
import com.wanqin.ktv.application.KTV_Application;
import com.wanqin.ktv.main.Activity_Main;
import com.wanqin.ktv.reg.Activity_Reg;
import com.wanqin.ktv.utils.HttpUtil;
import com.wanqin.ktv.utils.JToast;
import com.wanqin.ktv.utils.MyJsonResponseHandler;

public class Activity_Login extends SherlockActivity implements OnClickListener {

	private ImageView left_Button;
	private ImageView right_Button, delete_user, delete_pass, user_ImageView,
			pass_ImageView;
	private EditText username_EditText, password_EditText;
	private Button login_Button, reg_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initActionBar();
		initView();
	}

	/**
	 * @Description: TODO(初始化控件)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-12-28 上午11:58:52
	 */
	private void initView() {
		delete_user = (ImageView) findViewById(R.id.delete_user);
		delete_pass = (ImageView) findViewById(R.id.delete_pass);
		username_EditText = (EditText) findViewById(R.id.username_EditText);
		password_EditText = (EditText) findViewById(R.id.password_EditText);
		login_Button = (Button) findViewById(R.id.login_Button);
		reg_Button = (Button) findViewById(R.id.reg_Button);
		user_ImageView = (ImageView) findViewById(R.id.user_ImageView);
		pass_ImageView = (ImageView) findViewById(R.id.pass_ImageView);
		delete_pass.setOnClickListener(this);
		delete_user.setOnClickListener(this);
		login_Button.setOnClickListener(this);
		reg_Button.setOnClickListener(this);
		username_EditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if (s.toString().length() > 0) {
					delete_user.setVisibility(View.VISIBLE);
					user_ImageView
							.setImageResource(R.drawable.login_user_hightlighted);
				} else {
					delete_user.setVisibility(View.INVISIBLE);
					user_ImageView.setImageResource(R.drawable.login_user);
				}
			}
		});
		password_EditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if (s.toString().length() > 0) {
					delete_pass.setVisibility(View.VISIBLE);
					pass_ImageView
							.setImageResource(R.drawable.login_key_hightlighted);
				} else {
					delete_pass.setVisibility(View.INVISIBLE);
					pass_ImageView.setImageResource(R.drawable.login_key);
				}
			}
		});
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
		left_Button.setImageResource(R.drawable.selector_close);
		left_Button.setOnClickListener(this);
		left_Button.setVisibility(View.VISIBLE);
		TextView tttTextView = (TextView) actionBarView
				.findViewById(R.id.title_ActionBar);

		tttTextView.setText("请登录");

		View right_Button  =findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}

	final static int REG = 60;
	final static int OK = 61;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			finish();
			Process.killProcess(Process.myPid());
			break;

		case R.id.delete_pass:
			password_EditText.setText("");
			pass_ImageView.setImageResource(R.drawable.login_key);
			break;
		case R.id.delete_user:
			username_EditText.setText("");
			user_ImageView.setImageResource(R.drawable.login_user);
			break;
		case R.id.login_Button:
			/*
			if (validate() == false) {
				return;
			}
			initNetWork_Login();*/
			Intent main = new Intent(Activity_Login.this, Activity_Main.class);
			startActivity(main);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			finish();
			break;
		case R.id.reg_Button:
			Intent intent = new Intent(this, Activity_Reg.class);
			startActivityForResult(intent, REG);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		}

	}

	private void initNetWork_Login() {
		String url = "http://120.24.238.250:9999/kpub/member_login.pub?memberPhone="
				+ username_EditText.getText().toString().trim()
				+ "&memberCiphertext="
				+ password_EditText.getText().toString().trim()
				+ "&clientType=android";
		HttpUtil.get(url, new MyJsonResponseHandler(url, this, KTV_Application.CHARSET){
			@Override
			public void onExecute(JSONObject response) {
				// TODO Auto-generated method stub
				SharedPreferences sp=getSharedPreferences("login", Context.MODE_PRIVATE);
				Editor editor=sp.edit();
				try {
					editor.putString("token", response.getString("token"));
					editor.commit();
					Intent main = new Intent(Activity_Login.this, Activity_Main.class);
					startActivity(main);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
					finish();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JToast.showErrorToast(getApplicationContext(), "服务器返回数据异常");
				}
				
			}
		});
		
	}

	private boolean validate() {
		if (username_EditText.getText().toString().trim().equals("")) {
			JToast.showWarnToast(getApplicationContext(), "请输入用户名");
			return false;
		}
		if (password_EditText.getText().toString().trim().equals("")) {
			JToast.showWarnToast(getApplicationContext(), "请输入密码");
			return false;
		}
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REG && resultCode == OK && data != null) {
			username_EditText.setText(data.getStringExtra("username"));
			password_EditText.setText(data.getStringExtra("password"));
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			finish();
			Process.killProcess(Process.myPid());
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
