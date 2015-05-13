/**   
 * 文件名：Activity_PersonCenter.java 
 * 类名称：Activity_PersonCenter   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2015-1-11 下午2:56:26  
 * Copyright 诸葛飞扬。JJ Corporation 2015 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2015-1-11 下午2:56:26   
 * 修改备注：   
 */
package com.wanqin.ktv.person;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.meg7.widget.CustomShapeImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.wanqin.ktv.R;
import com.wanqin.ktv.customview.PicPopupWindow;
import com.wanqin.ktv.utils.ImageUtils;
import com.wanqin.ktv.utils.JToast;

/**
 * @ClassName: Activity_PersonCenter
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2015-1-11 下午2:56:26
 * 
 */
public class Activity_PersonCenter extends SherlockActivity implements
		OnClickListener {

	private ImageView right_Button;
	private ImageView left_Button;
	private Button submit_Button;
	private CustomShapeImageView customShapeImageView_person_touxiang;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_personcenter);
		initViews();
	}
	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @date 2015-1-11 下午4:26:23
	 */
	private void initViews() {
		
		submit_Button=(Button) findViewById(R.id.submit_Button);
		submit_Button.setOnClickListener(this);
		customShapeImageView_person_touxiang=(CustomShapeImageView) findViewById(R.id.customShapeImageView_person_touxiang);
		customShapeImageView_person_touxiang.setOnClickListener(this);
	}
	private void initActionBar() {
		initDisplayOptions();
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

		tttTextView.setText("个人中心");

		right_Button = (ImageView) findViewById(R.id.right_ActionBar_Button);
		// right_Button.setImageResource(R.drawable.selector_userinfo);
		right_Button.setOnClickListener(this);
		right_Button.setVisibility(View.INVISIBLE);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_ActionBar_Button:
			finish();
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			break;

		case R.id.submit_Button:
			JToast.showToast(getApplicationContext(), "修改成功");
			break;
		case R.id.customShapeImageView_person_touxiang:
			showPic();
			break;
		}

	}
	private DisplayImageOptions options;
	private ImageLoader mImageLoader;

	private void initDisplayOptions() {
		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.head)
				// 设置正在加载图片
				// .showImageOnLoading(R.drawable.ic_stub) //1.8.7新增
				// .showImageForEmptyUri(R.drawable.tupian)
				.showImageOnFail(R.drawable.head)
				// 设置加载失败图片
				.cacheInMemory(false).cacheOnDisc(true)
				.displayer(new RoundedBitmapDisplayer(0)) // 设置图片角度,0为方形，360为圆角
				.build();

		mImageLoader = ImageLoader.getInstance();

		// 缓存目录
		// 有SD卡
		// path=/sdcard/Android/data/com.example.universalimageloadertest/cache
		// 无SD卡 path=/data/data/com.example.universalimageloadertest/cache
		File cacheDir = StorageUtils.getCacheDirectory(this);
		Log.e("jj", "cacheDir path=" + cacheDir.getAbsolutePath());
	}

	private static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {

		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					// FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);

					System.out.println("获取图片");
				}
			}
		}
	}

	File take_photo_file;
	private static int RESULT_LOAD_IMAGE = 1;
	private static int RESULT_TAKE_PHOTO = 2;
	private PicPopupWindow menuWindow_all_in_one;
	Bitmap photo;

	private void showPic() {
		menuWindow_all_in_one = new PicPopupWindow(this, itemsOnClick, "23");
		// 显示窗口
		menuWindow_all_in_one.showAtLocation(this.findViewById(R.id.root),
				Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
	}

	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {
		public void onClick(View v) {
			menuWindow_all_in_one.dismiss();
			switch (v.getId()) {
			case R.id.btn_take_photo:
				destoryBimap();
				String state = Environment.getExternalStorageState();
				if (state.equals(Environment.MEDIA_MOUNTED)) {
					String name = new DateFormat().format("yyyyMMdd_hhmmss",
							Calendar.getInstance(Locale.CHINA)) + ".jpg";
					String saveDir = Environment.getExternalStorageDirectory()
							+ "/isite";
					File dir = new File(saveDir);
					if (!dir.exists()) {
						dir.mkdir();
					}
					take_photo_file = new File(saveDir, name);
					take_photo_file.delete();
					if (!take_photo_file.exists()) {
						try {
							take_photo_file.createNewFile();
						} catch (IOException e) {
							// progress.dismiss();
							Toast.makeText(Activity_PersonCenter.this,
									"未找到图片", Toast.LENGTH_LONG).show();
							return;
						}
					}
					Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					intent.putExtra(MediaStore.EXTRA_OUTPUT,
							Uri.fromFile(take_photo_file));
					startActivityForResult(intent, RESULT_TAKE_PHOTO);
				} else {
					Toast.makeText(Activity_PersonCenter.this, "未发现SDCard",
							Toast.LENGTH_LONG).show();
				}
				break;
			case R.id.btn_pick_photo:
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
				break;
			case R.id.btn_look_photo:
				/*
				 * Intent intent = new Intent(UpLoadImageActivity.this,
				 * ImageLook.class);
				 * 
				 * // intent.putExtra("url", ProcessorHandler.HTTP + url);
				 * StationRecord.this.startActivity(intent);
				 */

				break;

			default:
				break;
			}
		}
	};
	private String picturePath;

	private void destoryBimap() {
		if (photo != null && !photo.isRecycled()) {
			photo.recycle();
			photo = null;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			picturePath = cursor.getString(columnIndex);// 获取图片的路径
			Log.v("jj", "选择后的图片地址：" + picturePath);
			// 对图片进行压缩
			picturePath = ImageUtils.getsaveimage(picturePath);

			System.out.println("选择图片的路径： " + picturePath);

			cursor.close();
			initNetWork_Submit_Image(picturePath);
		} else if (requestCode == RESULT_TAKE_PHOTO && resultCode == RESULT_OK) {
			if (resultCode == Activity.RESULT_OK) {
				if (take_photo_file != null && take_photo_file.exists()) {
					BitmapFactory.Options options = new BitmapFactory.Options();
					options.inSampleSize = 2;
					photo = BitmapFactory.decodeFile(take_photo_file.getPath(),
							options);
					picturePath = take_photo_file.getPath();
					// 对图片进行压缩
					picturePath = ImageUtils.getsaveimage(picturePath);

				} else {
					Toast.makeText(this, "未发现图片", Toast.LENGTH_LONG).show();
				}

				// scroolBottom();
				System.out.println("选择相机图片的路径： " + picturePath);
				initNetWork_Submit_Image(picturePath);

			}
		} else if (resultCode == 0) {
			/*
			 * if (data != null) { operators = data.getStringExtra("operators");
			 * btn_selectMoshi.setText(operators); }
			 */
		}
	}
	/**
	 * @Description: TODO(*)
	 * @author 诸葛飞扬。JJ
	 * @param picturePath2 
	 * @date 2015-1-11 下午4:33:11
	 */
	private void initNetWork_Submit_Image(String picturePath2) {
		// TODO Auto-generated method stub
		customShapeImageView_person_touxiang.setImageBitmap(BitmapFactory.decodeFile(picturePath2));
	}
}
