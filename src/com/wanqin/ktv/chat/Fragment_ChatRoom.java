package com.wanqin.ktv.chat;

import java.lang.reflect.Field;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wanqin.ktv.R;
import com.wanqin.ktv.utils.JToast;
import com.wanqin.ktv.utils.ListViewItemHeightUtil;

public class Fragment_ChatRoom extends Fragment implements OnClickListener {
	static Fragment_ChatRoom fragment_ChatRoom;
	private ListView listView;
	private Adapter_ListView adapter;

	public static Fragment_ChatRoom getInstance() {
		if (fragment_ChatRoom == null) {
			fragment_ChatRoom = new Fragment_ChatRoom();
		}
		return fragment_ChatRoom;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fragment_ChatRoom = this;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_chatroom, null);
ImageView gift_ImageView=(ImageView) view.findViewById(R.id.gift_ImageView);
gift_ImageView.setOnClickListener(this);
		listView = (ListView) view.findViewById(R.id.listView);
		adapter = new Adapter_ListView();
		listView.setAdapter(adapter);
		new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.currentThread().sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (getActivity()!=null&&!getActivity().isFinishing()) {
						getActivity().runOnUiThread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								count++;
								adapter.notifyDataSetChanged();
								listView.setStackFromBottom(true);
								listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
							}
						});
					}
					

				}
			};
		}.start();
		return view;
	}

	int count = 1;

	class Adapter_ListView extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return count;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			// TODO Auto-generated method stub
			view = LayoutInflater.from(getActivity()).inflate(
					R.layout.item_listview_publiccharroom, null);
			TextView textView = (TextView) view.findViewById(R.id.textView);
			textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
			String html = "<img src='songli'/><font color='#00FF00' style='font-size:12px'>"
					+ "大富豪"
					+ position
					+ "</font> <font color='#666666' style='font-size:12px'>送给</font> <font color='#9933FF' style='font-size:12px'>"
					+ "清纯小美眉" + position + "</font><font color='#666666' style='font-size:12px'> 1辆宝马跑车</font>";
			// <font color="#00FF00">大富豪</font> <font color="#666666">送给</font>
			// <font color="#9933FF">清纯小美眉</font>
			CharSequence charSequence = Html.fromHtml(html, new ImageGetter() {

				@Override
				public Drawable getDrawable(String source) {
					// TODO Auto-generated method stub
					// 获得系统资源的信息，比如图片信息
					Drawable drawable = getResources().getDrawable(
							getResourceId(source));
					// 第三个图片文件按照50%的比例进行压缩
					if (source.equals("image3")) {
						drawable.setBounds(0, 0,
								drawable.getIntrinsicWidth() / 2,
								drawable.getIntrinsicHeight() / 2);
					} else {
						drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
								drawable.getIntrinsicHeight());
					}
					return drawable;
				}
			}, null);
			
			textView.setText(charSequence);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			return view;
		}

	}

	public int getResourceId(String name) {
		try {
			// 根据资源的ID的变量名获得Field的对象,使用反射机制来实现的
			Field field = R.drawable.class.getField(name);
			// 取得并返回资源的id的字段(静态变量)的值，使用反射机制
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.gift_ImageView:
			JToast.showToast(getActivity(), "给美女送礼物咯");
			break;

		default:
			break;
		}

	}

}
