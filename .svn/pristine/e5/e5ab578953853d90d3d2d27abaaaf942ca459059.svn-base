package com.wanqin.ktv.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Locale;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;

public class ImageUtils {
	private static Context context;

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
		float hh = 500;// 这里设置高度为800f
		float ww = 500;// 这里设置宽度为480f
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
	public static String getsaveimage(String srcPath) {

		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// 开始读入图片，此时把options.inJustDecodeBounds 设回true了
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);// 此时返回bm为空

		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		newOpts.inJustDecodeBounds = false;
		// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
		/*float hh = 1920;// 这里设置高度为800f
		float ww = 1080;// 这里设置宽度为480f*/
		float hh = 1024;// 这里设置高度为800f
		float ww = 768;// 这里设置宽度为480f
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

		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		bitmap = compressImage(bitmap);

		String name = new DateFormat().format("yyyyMMdd_hhmmss",
				Calendar.getInstance(Locale.CHINA))
				+ ".jpg";
		String saveDir = Environment.getExternalStorageDirectory() + "/isite";
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

	// 图片按比例大小压缩方法（根据Bitmap图片压缩）
	public static Bitmap comp(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		if (baos.toByteArray().length / 1024 > 1024) {// 判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
			baos.reset();// 重置baos即清空baos
			image.compress(Bitmap.CompressFormat.JPEG, 50, baos);// 这里压缩50%，把压缩后的数据存放到baos中
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// 开始读入图片，此时把options.inJustDecodeBounds 设回true了
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
		float hh = 500f;// 这里设置高度为800f
		float ww = 500f;// 这里设置宽度为480f
		// 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
		int be = 1;// be=1表示不缩放
		if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// 设置缩放比例
		// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		isBm = new ByteArrayInputStream(baos.toByteArray());
		bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩
	}

	/**
	 * @Description: TODO(给图片加水印)
	 * @author 诸葛飞扬。JJ
	 * @date 2013-12-5 下午3:42:16
	 * @param bitmap_Drawable
	 *            要加水印的Drawable
	 * @param string
	 *            水印文字
	 * @return
	 */
	public static Drawable addWaterMark(Context context,
			Drawable bitmap_Drawable, String string) {
		ImageUtils.context = context;
		if (string.length() > 14) {
			string = string.substring(0, 11) + "···";
			Log.v("jj", string.length() + "");
		}
		BitmapDrawable bd = (BitmapDrawable) bitmap_Drawable;
		Bitmap bitmap = bd.getBitmap();
		int width = bitmap.getWidth();
		int hight = bitmap.getHeight();
		System.out.println("宽" + width + "高" + hight);
		Bitmap icon = Bitmap
				.createBitmap(width, hight, Bitmap.Config.ARGB_8888); // 建立一个空的BItMap
		Canvas canvas = new Canvas(icon);// 初始化画布绘制的图像到icon上
		Paint photoPaint = new Paint(); // 建立画笔
		photoPaint.setDither(true); // 获取跟清晰的图像采样
		photoPaint.setFilterBitmap(true);// 过滤一些
		Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());// 创建一个指定的新矩形的坐标
		Rect dst = new Rect(0, 0, width, hight);// 创建一个指定的新矩形的坐标
		canvas.drawBitmap(bitmap, src, dst, photoPaint);// 将photo 缩放或则扩大到
														// dst使用的填充区photoPaint

		Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG
				| Paint.DEV_KERN_TEXT_FLAG);// 设置画笔
		textPaint.setTextSize(dip2px(context, 10.0f));// 字体大小
		textPaint.setTypeface(Typeface.DEFAULT_BOLD);// 采用默认的宽度
		textPaint.setColor(Color.BLACK);// 采用的颜色
		// textPaint.setShadowLayer(3f, 1,
		// 1,this.getResources().getColor(android.R.color.background_dark));//影音的设置
		// if (string.length()<14) {
		// canvas.drawText(string, computeSpacing(string.length()),
		// dip2px(context,25), textPaint);//绘制上去字，开始未知x,y采用那只笔绘制
		// }else {
		canvas.drawText(string, dip2px(context, 15), dip2px(context, 25),
				textPaint);// 绘制上去字，开始未知x,y采用那只笔绘制
		// }

		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
		// image.setImageBitmap(icon);
		// saveMyBitmap(icon);

		BitmapDrawable bit = new BitmapDrawable(icon);

		return bit;

	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public static int computeSpacing(int len) {
		// len=(149-(len*dip2px(context, 10)))/2-6;
		len = 149 / 2 - dip2px(context, len * 5);
		len = dip2px(context, len);
		return len;

	}

	public static String addSpacing(String string) {
		// len=(149-(len*dip2px(context, 10)))/2-6;
		int len = string.length();
		switch (len) {
		case 1:
			string = "     " + string + "       ";
			break;
		case 2:
			string = "     " + string + "      ";
			break;
		case 3:
			string = "    " + string + "     ";
			break;
		case 4:
			string = "    " + string + "     ";
			break;
		case 5:
			string = "   " + string + "     ";
			break;
		case 6:
			string = "   " + string + "    ";
			break;
		case 7:
			string = "    " + string + "      ";
			break;
		case 8:
			string = "     " + string + "       ";
			break;
		case 9:
			string = "     " + string + "       ";
			break;
		case 10:
			string = "     " + string + "       ";
			break;
		case 11:
			string = "     " + string + "       ";
			break;
		case 12:
			string = "     " + string + "       ";
			break;
		case 13:
			string = "     " + string + "       ";
			break;
		default:
			break;
		}

		return string;

	}
}
