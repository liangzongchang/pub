/**
 * 文件名: GridViewItemHeightUtil.java
 * 类名称：GridViewItemHeightUtil
 * 类描述：TODO
 * 创建人：潘军
 * 创建时间: 2014年7月31日 下午2:57:15
 * Copyright: 潘军 Corporation 2014 版权所有    
 * 版本信息：
 * 修改人：
 * 修改时间: 2014年7月31日 下午2:57:15
 * 修改备注: 
 */
package com.wanqin.ktv.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

/**
 * @ClassName: GridViewItemHeightUtil
 * @Description: TODO
 * @author: 潘军
 * @date: 2014年7月31日 下午2:57:15
 */
public class GridViewItemHeightUtil {

	public static void setGridViewHeightBaseOnChildren(GridView gridView,
			Context context) {
		ListAdapter listAdapter = gridView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		int row = 0;
		int count = gridView.getCount();
		int col = 4;
		// int col = gridView.getNumColumns();

		if (count % col == 0) {
			row = count / col;
		} else {
			row = count / col + 1;
		}

		View view = listAdapter.getView(0, null, gridView);
		view.measure(0, 0);
		totalHeight = view.getMeasuredHeight() * row;

		ViewGroup.LayoutParams params = gridView.getLayoutParams();
		params.height = totalHeight + dip2px(context, 1) * (row - 1);
		/*
		 * params.height = totalHeight + gridView.getHorizontalSpacing() (row -
		 * 1);
		 */
		gridView.setLayoutParams(params);
	}

	public static int getGridViewHeightBaseOnChildren(GridView gridView,
			Context context) {
		ListAdapter listAdapter = gridView.getAdapter();
		if (listAdapter == null) {
			return 0;
		}

		int totalHeight = 0;

		View view = listAdapter.getView(0, null, gridView);
		view.measure(0, 0);
		totalHeight = view.getMeasuredHeight();

		return totalHeight + dip2px(context, 1);
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
