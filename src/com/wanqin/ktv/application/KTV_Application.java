/**   
 * �ļ�����.java 
 * �����ƣ�   
 * ��������      
 * �����ˣ������JJ   
 * ����ʱ�䣺2014-12-28 ����9:58:39  
 * Copyright �����JJ Corporation 2014 ��Ȩ����     
 * �汾��Ϣ��    
 * �޸��ˣ�jj   
 * �޸�ʱ�䣺2014-12-28 ����9:58:39   
 * �޸ı�ע��   
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
 * @Description: TODO(Ӧ�ó��򻷾�)
 * @author �����JJ
 * @date 2014-12-28 ����9:58:39
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
					"BMapManager  ��ʼ������!", Toast.LENGTH_LONG).show();
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

	// �����¼���������������ͨ�������������Ȩ��֤�����
	public static class MyGeneralListener implements MKGeneralListener {

		@Override
		public void onGetNetworkState(int iError) {
			if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"���������������", Toast.LENGTH_LONG).show();
			} else if (iError == MKEvent.ERROR_NETWORK_DATA) {
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"������ȷ�ļ���������", Toast.LENGTH_LONG).show();
			}
			// ...
		}

		@Override
		public void onGetPermissionState(int iError) {
			// ����ֵ��ʾkey��֤δͨ��
			if (iError != 0) {
				// ��ȨKey����
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"AndroidManifest.xml �ļ�������ȷ����ȨKey,������������������Ƿ�������error: "
								+ iError, Toast.LENGTH_LONG).show();
				KTV_Application.getInstance().m_bKeyRight = false;
			} else {
				KTV_Application.getInstance().m_bKeyRight = true;
				Toast.makeText(
						KTV_Application.getInstance().getApplicationContext(),
						"key��֤�ɹ�", Toast.LENGTH_LONG).show();
			}
		}
	}
}
