/**   
* 文件名：Activity_ChatInSingleShop.java 
* 类名称：Activity_ChatInSingleShop   
* 类描述：      
* 创建人：诸葛飞扬。JJ   
* 创建时间：2015-1-10 下午9:43:38  
* Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
* 版本信息：    
* 修改人：jj   
* 修改时间：2015-1-10 下午9:43:38   
* 修改备注：   
*/ 
package com.wanqin.ktv.chat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.jialin.chat.Message;
import com.jialin.chat.MessageAdapter;
import com.jialin.chat.MessageInputToolBox;
import com.jialin.chat.OnOperationListener;
import com.jialin.chat.Option;
import com.wanqin.ktv.R;

/**
 * @ClassName: Activity_ChatInSingleShop
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-10 下午9:43:38
 * 
 */
public class Activity_ChatInSingleShop extends SherlockFragmentActivity implements
		OnClickListener {
	public MessageInputToolBox box;
	public ListView listView;
	public MessageAdapter adapter;
	private ImageView left_Button;
	private ImageView right_Button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_chat_singleshop);
		initMessageInputToolBox();

		initListView();
	}
	private void initActionBar() {

		LayoutInflater inflater = getLayoutInflater();
		View actionBarView = inflater.inflate(R.layout.actionbar_image, null);
		actionBarView.setOnClickListener(this);
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.white));
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
		TextView tttTextView = (TextView) actionBarView
				.findViewById(R.id.title_ActionBar);

		tttTextView.setText("招贤纳士");

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}

	/**
	 * init MessageInputToolBox
	 * 
	 * @param view
	 */
	@SuppressLint("ShowToast")
	private void initMessageInputToolBox() {
		box = (MessageInputToolBox) findViewById(R.id.messageInputToolBox);
		box.setOnOperationListener(new OnOperationListener() {

			@Override
			public void send(String content) {

				System.out.println("===============" + content);

				Message message = new Message(0, 1, "Tom", "avatar", "Jerry",
						"avatar", content, true, true, new Date());

				adapter.getData().add(message);
				listView.setSelection(listView.getBottom());

				// Just demo
				createReplayMsg(message);
			}

			@Override
			public void selectedFace(String content) {

				System.out.println("===============" + content);
				Message message = new Message(Message.MSG_TYPE_FACE,
						Message.MSG_STATE_SUCCESS, "Tomcat", "avatar", "Jerry",
						"avatar", content, true, true, new Date());
				adapter.getData().add(message);
				listView.setSelection(listView.getBottom());

				// Just demo
				createReplayMsg(message);
			}

			@Override
			public void selectedFuncation(int index) {

				System.out.println("===============" + index);

				switch (index) {
				case 0:
					// do some thing
					break;
				case 1:
					// do some thing
					break;

				default:
					break;
				}
				Toast.makeText(Activity_ChatInSingleShop.this,
						"Do some thing here, index :" + index, 1000).show();

			}

		});

		ArrayList<String> faceNameList = new ArrayList<String>();
		for (int x = 1; x <= 10; x++) {
			faceNameList.add("big" + x);
		}
		for (int x = 1; x <= 10; x++) {
			faceNameList.add("big" + x);
		}

		ArrayList<String> faceNameList1 = new ArrayList<String>();
		for (int x = 1; x <= 7; x++) {
			faceNameList1.add("cig" + x);
		}

		ArrayList<String> faceNameList2 = new ArrayList<String>();
		for (int x = 1; x <= 24; x++) {
			faceNameList2.add("dig" + x);
		}

		Map<Integer, ArrayList<String>> faceData = new HashMap<Integer, ArrayList<String>>();
		faceData.put(R.drawable.em_cate_magic, faceNameList2);
		faceData.put(R.drawable.em_cate_rib, faceNameList1);
		faceData.put(R.drawable.em_cate_duck, faceNameList);
		box.setFaceData(faceData);

		List<Option> functionData = new ArrayList<Option>();
		for (int x = 0; x < 5; x++) {
			Option takePhotoOption = new Option(Activity_ChatInSingleShop.this, "Take",
					R.drawable.take_photo);
			Option galleryOption = new Option(Activity_ChatInSingleShop.this, "Gallery",
					R.drawable.gallery);
			functionData.add(galleryOption);
			functionData.add(takePhotoOption);
		}
		box.setFunctionData(functionData);
	}

	private void initListView() {
		listView = (ListView) findViewById(R.id.messageListview);

		// create Data
		Message message = new Message(Message.MSG_TYPE_TEXT,
				Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
				"Hi", false, true, new Date(System.currentTimeMillis()
						- (1000 * 60 * 60 * 24) * 8));
		Message message1 = new Message(Message.MSG_TYPE_TEXT,
				Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
				"Hello World", true, true, new Date(System.currentTimeMillis()
						- (1000 * 60 * 60 * 24) * 8));
		Message message2 = new Message(Message.MSG_TYPE_PHOTO,
				Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
				"device_2014_08_21_215311", false, true, new Date(
						System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 7));
		Message message3 = new Message(Message.MSG_TYPE_TEXT,
				Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
				"Haha", true, true, new Date(System.currentTimeMillis()
						- (1000 * 60 * 60 * 24) * 7));
		Message message4 = new Message(Message.MSG_TYPE_FACE,
				Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
				"big3", false, true, new Date(System.currentTimeMillis()
						- (1000 * 60 * 60 * 24) * 7));
		Message message5 = new Message(Message.MSG_TYPE_FACE,
				Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
				"big2", true, true, new Date(System.currentTimeMillis()
						- (1000 * 60 * 60 * 24) * 6));
		Message message6 = new Message(Message.MSG_TYPE_TEXT,
				Message.MSG_STATE_FAIL, "Tom", "avatar", "Jerry", "avatar",
				"test send fail", true, false, new Date(
						System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 6));
		Message message7 = new Message(Message.MSG_TYPE_TEXT,
				Message.MSG_STATE_SENDING, "Tom", "avatar", "Jerry", "avatar",
				"test sending", true, true, new Date(System.currentTimeMillis()
						- (1000 * 60 * 60 * 24) * 6));

		List<Message> messages = new ArrayList<Message>();
		messages.add(message);
		messages.add(message1);
		messages.add(message2);
		messages.add(message3);
		messages.add(message4);
		messages.add(message5);
		messages.add(message6);
		messages.add(message7);

		adapter = new MessageAdapter(Activity_ChatInSingleShop.this, messages);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();

		listView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				box.hide();
				return false;
			}
		});

	}

	private void createReplayMsg(Message message) {

		final Message reMessage = new Message(message.getType(), 1, "Tom",
				"avatar", "Jerry", "avatar", message.getType() == 0 ? "Re:"
						+ message.getContent() : message.getContent(), false,
				true, new Date());
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000 * (new Random().nextInt(3) + 1));
					Activity_ChatInSingleShop.this.runOnUiThread(new Runnable() {

						@Override
						public void run() {
							adapter.getData().add(reMessage);
							listView.setSelection(listView.getBottom());
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			finish();
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			break;

		default:
			break;
		}
		
	}

}
