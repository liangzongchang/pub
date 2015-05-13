package com.wanqin.ktv.chat;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ext.SatelliteMenu;
import android.view.ext.SatelliteMenu.SateliteClickedListener;
import android.view.ext.SatelliteMenuItem;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.wanqin.ktv.R;
import com.wanqin.ktv.utils.JToast;

public class Fragment_RankingList extends Fragment implements OnClickListener {
	public static Fragment_RankingList fragment_RankingList;
	ListView listView;
	private Adapter_Renqi adapter;
	public static Fragment_RankingList getInstance(){
		if (fragment_RankingList==null) {
			fragment_RankingList=new Fragment_RankingList();
		}
		return fragment_RankingList;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		fragment_RankingList=this;
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_rankinglist, null);
		listView=(ListView) view.findViewById(R.id.listView);
		SatelliteMenu menu = (SatelliteMenu) view.findViewById(R.id.menu);
		List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
	/*	items.add(new SatelliteMenuItem(4, R.drawable.ic_launcher));
		items.add(new SatelliteMenuItem(4, R.drawable.ic_launcher));
		items.add(new SatelliteMenuItem(4, R.drawable.ic_launcher));*/
		items.add(new SatelliteMenuItem(3, R.drawable.fujin));
		items.add(new SatelliteMenuItem(2, R.drawable.fuhao));
		items.add(new SatelliteMenuItem(1, R.drawable.renqi));
		   menu.addItems(items);        
	        menu.setSatelliteDistance(250);
	        menu.setTotalSpacingDegree(100);
	        menu.setCloseItemsOnClick(true);
	        menu.setExpandDuration(500);
	        menu.setMainImage(R.drawable.top);
	        menu.setOnItemClickedListener(new SateliteClickedListener() {
				
				public void eventOccured(int id) {
					switch (id) {
					case 1:
						JToast.showToast(getActivity(), "»À∆¯∞Ò");
						break;

					case 2:
						JToast.showToast(getActivity(), "∏ª∫¿∞Ò");
						break;
					case 3:
						JToast.showToast(getActivity(), "æ‡¿Î∞Ò");
						break;
					}
				}
			});
	        adapter=new Adapter_Renqi();
	        listView.setAdapter(adapter);
		return view;
	}
	class Adapter_Renqi extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 10;
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
			if (position==0) {
				view =LayoutInflater.from(getActivity()).inflate(R.layout.item_listview_top_renqi, null);
			}else {
				view=LayoutInflater.from(getActivity()).inflate(R.layout.item_listview_renqi, null);
				TextView top_TextView=(TextView) view.findViewById(R.id.top_TextView);
				top_TextView.setText((position+3)+"");
			}
			
			return view;
		}
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
