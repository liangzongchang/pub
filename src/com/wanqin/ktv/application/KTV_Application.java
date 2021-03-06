/**   
 * 文件名：.java 
 * 类名称：   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-12-28 上午9:58:39  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-12-28 上午9:58:39   
 * 修改备注：   
 */
package com.wanqin.ktv.application;

import java.io.File;
import java.io.IOException;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;
import com.wanqin.ktv.dao.SQLiteHelperOrm;

/**
 * @ClassName:
 * @Description: TODO(应用程序环境)
 * @author 诸葛飞扬。JJ
 * @date 2014-12-28 上午9:58:39
 * 
 */
public class KTV_Application extends Application {
	private static KTV_Application mInstance = null;
	public boolean m_bKeyRight = true;
	public BMapManager mBMapManager = null;
	private SQLiteHelperOrm sqLiteHelperOrm;
	private SQLiteHelperOrm orm;
	public final static String CHARSET = "utf-8";

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		initEngineManager(this);
		createDataBase();
	}

	public void initEngineManager(Context context) {
		if (mBMapManager == null) {
			mBMapManager = new BMapManager(context);
		}

		if (!mBMapManager.init(new MyGeneralListener())) {
			Toast.makeText(
					KTV_Application.getInstance().getApplicationContext(),
					"BMapManager  初始化错误!", Toast.LENGTH_LONG).show();
		}
	}

	public static KTV_Application getInstance() {
		return mInstance;
	}

	private void createDataBase() {
		File f = new File(SQLiteHelperOrm.DATABASE_PATH);
		if (!f.getParentFile().exists()) {
		     f.getParentFile().mkdirs();
		}
		if (!f.exists()) {
		  try {
		    f.createNewFile();
		       } catch (IOException e) {
		       e.printStackTrace();
		      }
		           SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
		                   SQLiteHelperOrm.DATABASE_PATH,null);
		           orm = new SQLiteHelperOrm(this);
		           orm.onCreate(db);
		           db.close();
		       }
	}

	// 常用事件监听，用来处理通常的网络错误，授权验证错误等
	public static class MyGeneralListener implements MKGeneralListener {

		@Override
		public void onGetNetworkState(int iError) {
			if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"您的网络出错啦！", Toast.LENGTH_LONG).show();
			} else if (iError == MKEvent.ERROR_NETWORK_DATA) {
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"输入正确的检索条件！", Toast.LENGTH_LONG).show();
			}
			// ...
		}

		@Override
		public void onGetPermissionState(int iError) {
			// 非零值表示key验证未通过
			if (iError != 0) {
				// 授权Key错误：
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"AndroidManifest.xml 文件输入正确的授权Key,并检查您的网络连接是否正常！error: "
								+ iError, Toast.LENGTH_LONG).show();
				KTV_Application.getInstance().m_bKeyRight = false;
			} else {
				KTV_Application.getInstance().m_bKeyRight = true;
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"key认证成功", Toast.LENGTH_LONG).show();
			}
		}
	}
}
