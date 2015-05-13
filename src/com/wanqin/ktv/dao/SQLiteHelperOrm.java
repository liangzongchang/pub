package com.wanqin.ktv.dao;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class SQLiteHelperOrm extends OrmLiteSqliteOpenHelper{
	public static final String DATABASE_PATH = Environment
            .getExternalStorageDirectory() + "/test.db";
	public SQLiteHelperOrm(Context context) {
		super(context, DATABASE_PATH, null, 1);
	}
    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {
        return SQLiteDatabase.openDatabase(DATABASE_PATH, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        return SQLiteDatabase.openDatabase(DATABASE_PATH, null,
                SQLiteDatabase.OPEN_READONLY);
    }
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		// TODO Auto-generated method stub
		try {
			TableUtils.createTable(connectionSource, CarUserBean.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub
		
	}
}
