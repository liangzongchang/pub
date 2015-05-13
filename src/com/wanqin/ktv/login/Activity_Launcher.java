package com.wanqin.ktv.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;
import com.wanqin.ktv.main.Activity_Main;

public class Activity_Launcher extends SherlockActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		new Thread(){
			public void run() {
				try {
					Thread.currentThread().sleep(3000);
					SharedPreferences sharedPreferences=getSharedPreferences("login", MODE_PRIVATE);
					if (!sharedPreferences.getString("token", "").equals("")) {
						Intent intent=new Intent(Activity_Launcher.this, Activity_Main.class);
						Activity_Launcher.this.startActivity(intent);
						Activity_Launcher.this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
						Activity_Launcher.this.finish();
					}else {
						Intent intent=new Intent(Activity_Launcher.this, Activity_Login.class);
						Activity_Launcher.this.startActivity(intent);
						Activity_Launcher.this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
						Activity_Launcher.this.finish();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			};
		}.start();
	}
}
