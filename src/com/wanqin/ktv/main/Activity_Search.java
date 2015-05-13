/**   
 * �ļ�����Activity_Search.java 
 * �����ƣ�Activity_Search   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2014-12-30 ����9:04:35  
 * Copyright �����JJ Corporation 2014 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2014-12-30 ����9:04:35   
 * �޸ı�ע��   
 */
package com.wanqin.ktv.main;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.wanqin.ktv.R;
import com.wanqin.ktv.utils.JToast;

/**
 * @ClassName: Activity_Search
 * @Description: TODO(*)
 * @author �����JJ
 * @date 2014-12-30 ����9:04:35
 * 
 */
public class Activity_Search extends SherlockActivity implements
		OnClickListener {
	private ImageView delete_search;
	private EditText search_EditText;
	private Button right_ActionBar_Button;
	private ListView hotKey_ListView;
	private List<String> hotkeys;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_search);
		initViews();
	}

	/**
	 * @Description: TODO(*)
	 * @author �����JJ
	 * @date 2015-1-6 ����9:05:04
	 */
	private void initViews() {
		initHotKeys();
		hotKey_ListView = (ListView) findViewById(R.id.hotKey_ListView);
		hotKey_ListView.setAdapter(new Adapter_HotKey());
	}

	/**
	 * @Description: TODO(��ȡ�ȴ�)
	 * @author �����JJ
	 * @date 2015-1-6 ����9:08:30
	 */
	private void initHotKeys() {
		hotkeys = new ArrayList<String>();
		String[] array = getResources().getStringArray(R.array.hotkey);
		for (int i = 0; i < array.length; i++) {
			hotkeys.add(array[i]);
		}
	}

	private void initActionBar() {

		LayoutInflater inflater = getLayoutInflater();
		View actionBarView = inflater.inflate(R.layout.actionbar_search, null);
		actionBarView.setOnClickListener(this);
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.white));
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setHomeButtonEnabled(false);
		getSupportActionBar().setLogo(R.drawable.ic_launcher);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		// getSupportActionBar().setTitle("��������");
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		getSupportActionBar().setCustomView(actionBarView);
		getSupportActionBar().setDisplayShowCustomEnabled(true);

		search_EditText = (EditText) actionBarView
				.findViewById(R.id.search_EditText);
		right_ActionBar_Button = (Button) actionBarView
				.findViewById(R.id.right_ActionBar_Button);
		right_ActionBar_Button.setOnClickListener(this);
		delete_search = (ImageView) actionBarView
				.findViewById(R.id.delete_search);
		delete_search.setOnClickListener(this);
		delete_search.setVisibility(View.INVISIBLE);
		search_EditText.addTextChangedListener(new TextWatcher() {

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
				if (s.toString().length() > 0) {
					delete_search.setVisibility(View.VISIBLE);
					right_ActionBar_Button.setText("����");
				} else {
					delete_search.setVisibility(View.INVISIBLE);
					right_ActionBar_Button.setText("ȡ��");
				}

			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			overridePendingTransition(R.anim.push_bottom_in,
					R.anim.push_bottom_out);
			return true;
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.right_ActionBar_Button:
			if (right_ActionBar_Button.getText().equals("ȡ��")) {
				finish();
				overridePendingTransition(R.anim.push_bottom_in,
						R.anim.push_bottom_out);
			}
			if (right_ActionBar_Button.getText().equals("����")) {

			}
			break;

		case R.id.delete_search:
			search_EditText.setText("");
			delete_search.setVisibility(View.INVISIBLE);
			break;
		}
	}

	class Adapter_HotKey extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if (hotkeys == null) {
				return 0;
			} else {
				int count = hotkeys.size() / 3;
				if (hotkeys.size() % 3 > 0) {
					count = count + 1;
				}
				return count;
			}

		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return hotkeys.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			view = LayoutInflater.from(Activity_Search.this).inflate(
					R.layout.item_listview_hotkey, null);
			final TextView hotkey_TextView1 = (TextView) view
					.findViewById(R.id.hotkey_TextView1);
			final TextView hotkey_TextView2 = (TextView) view
					.findViewById(R.id.hotkey_TextView2);
			final TextView hotkey_TextView3 = (TextView) view
					.findViewById(R.id.hotkey_TextView3);
			if ((position * 3 - 1 + 1) < hotkeys.size()) {
				hotkey_TextView1.setText(hotkeys.get(position * 3 - 1 + 1));
			}
			if ((position * 3 - 1 + 2) < hotkeys.size()) {
				hotkey_TextView2.setText(hotkeys.get(position * 3 - 1 + 2));
			}
			if ((position * 3 - 1 + 3) < hotkeys.size()) {
				hotkey_TextView3.setText(hotkeys.get(position * 3 - 1 + 3));
			}
			hotkey_TextView1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					search_EditText.setText(hotkey_TextView1.getText().toString());
				}
			});
			hotkey_TextView2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					search_EditText.setText(hotkey_TextView2.getText().toString());

				}
			});
			hotkey_TextView3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					search_EditText.setText(hotkey_TextView3.getText().toString());

				}
			});
			return view;
		}

	}
}
