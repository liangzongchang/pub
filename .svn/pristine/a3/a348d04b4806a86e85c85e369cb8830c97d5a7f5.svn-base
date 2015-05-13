/**   
 * 文件名：ImageUtil.java 
 * 类名称：ImageUtil   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-11-21 下午2:25:56  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-11-21 下午2:25:56   
 * 修改备注：   
 */
package com.wanqin.ktv.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

/**
 * @ClassName: ImageUtil
 * @Description: TODO(图片处理工具类)
 * @author 诸葛飞扬。JJ
 * @date 2014-11-21 下午2:25:56
 * 
 */
public class ImageUtil {
	/**
	 * 
	 * 将bitmap转换成base64字符串
	 * 
	 * @param bitmap
	 * @return base64 字符串
	 */
	public static String bitmaptoBase64(Bitmap bitmap, int bitmapQuality) {
		
		// 将Bitmap转换成字符串
		String string = null;
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.JPEG, bitmapQuality, bStream);
		byte[] bytes = bStream.toByteArray();
		string = Base64.encodeToString(bytes, Base64.DEFAULT);
		return string;
	}

	/**
	 * 将base64转换成bitmap图片
	 * 
	 * @param string
	 *            base64字符串
	 * @return bitmap
	 */
	public static Bitmap base64toBitmap(String string) {
		// 将字符串转换成Bitmap类型
		Bitmap bitmap = null;
		try {
			byte[] bitmapArray;
			bitmapArray = Base64.decode(string, Base64.DEFAULT);
			bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
					bitmapArray.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}
	// 图片按比例大小压缩方法（根据路径获取图片并压缩）
		public static Bitmap getimage(String srcPath) {
			BitmapFactory.Options newOpts = new BitmapFactory.Options();
			// 开始读入图片，此时把options.inJustDecodeBounds 设回true了
			newOpts.inJustDecodeBounds = true;
			Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);// 此时返回bm为空

			// newOpts.inJustDecodeBounds = false;
			int w = newOpts.outWidth;
			int h = newOpts.outHeight;
			newOpts.inJustDecodeBounds = false;
			// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
			float hh = 1200;// 这里设置高度为800f
			float ww = 1200;// 这里设置宽度为480f
			Log.v("jj", "照片的原始宽高：" + w + ":" + h);
			// 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
			int be = 1;// be=1表示不缩放
			if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
				be = (int) (newOpts.outWidth / ww);
				newOpts.inSampleSize = be + 2;// 设置缩放比例
			} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
				be = (int) (newOpts.outHeight / hh);
				newOpts.inSampleSize = be + 2;// 设置缩放比例
			}
			if (be <= 0) {
				be = 1;
				newOpts.inSampleSize = be;// 设置缩放比例
			}
			Log.v("jj", "getimage缩放为" + be + "分之一");

			// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
			bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
			return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩
		}
		// 图片按比例大小压缩方法（根据路径获取图片并压缩）
				public static String getthumbimage(File file) {
					BitmapFactory.Options newOpts = new BitmapFactory.Options();
					// 开始读入图片，此时把options.inJustDecodeBounds 设回true了
					newOpts.inJustDecodeBounds = true;
					Bitmap bitmap = BitmapFactory.decodeFile(file.getPath(), newOpts);// 此时返回bm为空

					int w = newOpts.outWidth;
					int h = newOpts.outHeight;
					newOpts.inJustDecodeBounds = false;
					// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
					/*float hh = 1920;// 这里设置高度为800f
					float ww = 1080;// 这里设置宽度为480f*/
					float hh = 200;// 这里设置高度为800f
					float ww = 200;// 这里设置宽度为480f
					// 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
					int be = 1;// be=1表示不缩放
					Log.v("jj", "照片的原始宽高：" + w + ":" + h);
					if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
						be = (int) (newOpts.outWidth / ww);
						newOpts.inSampleSize = be + 2;// 设置缩放比例
					} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
						be = (int) (newOpts.outHeight / hh);
						newOpts.inSampleSize = be + 2;// 设置缩放比例
					}
					if (be <= 0) {
						be = 1;
						newOpts.inSampleSize = be;// 设置缩放比例
					}
					Log.v("jj", "getsaveimage缩放为" + be + "分之一");

					// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了

					bitmap = BitmapFactory.decodeFile(file.getPath(), newOpts);
					bitmap = compressImage(bitmap);

					String name = "thumb_"+file.getName();
					String saveDir = Environment.getExternalStorageDirectory() + "/popychat/media";
					File dir = new File(saveDir);
					if (!dir.exists()) {
						dir.mkdir();
					}
					// 保存入sdCard
					File file2 = new File(saveDir, name);
					try {
						FileOutputStream out = new FileOutputStream(file2);
						if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)) {
							out.flush();
							out.close();
							bitmap.recycle();
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					return file2.getPath();// 压缩好比例大小后再进行质量压缩
				}
				// 图片按比例大小压缩方法（根据路径获取图片并压缩）
				public static String getsaveimage(File file) {

					BitmapFactory.Options newOpts = new BitmapFactory.Options();
					// 开始读入图片，此时把options.inJustDecodeBounds 设回true了
					newOpts.inJustDecodeBounds = true;
					Bitmap bitmap = BitmapFactory.decodeFile(file.getPath(), newOpts);// 此时返回bm为空

					int w = newOpts.outWidth;
					int h = newOpts.outHeight;
					newOpts.inJustDecodeBounds = false;
					// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
					/*float hh = 1920;// 这里设置高度为800f
					float ww = 1080;// 这里设置宽度为480f*/
					float hh = 1200;// 这里设置高度为800f
					float ww = 1200;// 这里设置宽度为480f
					// 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
					int be = 1;// be=1表示不缩放
					Log.v("jj", "照片的原始宽高：" + w + ":" + h);
					if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
						be = (int) (newOpts.outWidth / ww);
						newOpts.inSampleSize = be + 2;// 设置缩放比例
					} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
						be = (int) (newOpts.outHeight / hh);
						newOpts.inSampleSize = be + 2;// 设置缩放比例
					}
					if (be <= 0) {
						be = 1;
						newOpts.inSampleSize = be;// 设置缩放比例
					}
					Log.v("jj", "getsaveimage缩放为" + be + "分之一");

					// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了

					bitmap = BitmapFactory.decodeFile(file.getPath(), newOpts);
					bitmap = compressImage(bitmap);

					String name = "compress_"+file.getName();
					String saveDir = Environment.getExternalStorageDirectory() + "/popychat/media";
					File dir = new File(saveDir);
					if (!dir.exists()) {
						dir.mkdir();
					}
					// 保存入sdCard
					File file2 = new File(saveDir, name);
					try {
						FileOutputStream out = new FileOutputStream(file2);
						if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)) {
							out.flush();
							out.close();
							bitmap.recycle();
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					if (file.exists()) {
						file.delete();
					}
					return file2.getPath();// 压缩好比例大小后再进行质量压缩
				}
		// 我们先看下质量压缩方法
		public static Bitmap compressImage(Bitmap image) {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
			int options = 100;
			while (baos.toByteArray().length / 1024 > 100) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
				baos.reset();// 重置baos即清空baos
				image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
				options -= 10;// 每次都减少10
			}
			ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
			Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
			return bitmap;
		}
		public static int px2dip(Context context, float pxValue) {
			final float scale = context.getResources().getDisplayMetrics().density;
			return (int) (pxValue / scale + 0.5f);
		}

		public static int dip2px(Context context, float dpValue) {
			final float scale = context.getResources().getDisplayMetrics().density;
			return (int) (dpValue * scale + 0.5f);
		}
		public static int colorFromIOStoAndroid(){
			return 0;
			
		}
}
