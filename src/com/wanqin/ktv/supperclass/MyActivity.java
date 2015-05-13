package com.wanqin.ktv.supperclass;

import android.content.Intent;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;

public class MyActivity extends SherlockActivity {
	@Override
	public void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		super.startActivity(intent);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}
}
