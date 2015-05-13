package com.wanqin.ktv.main;

import com.wanqin.ktv.R;
import com.wanqin.ktv.chat.Fragment_Chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Fragment_Appointment extends Fragment {
	private ListView listView;
	static Fragment_Appointment fragment_Appointment;
	public synchronized static Fragment_Appointment getInstance() {
		if (fragment_Appointment == null) {
			fragment_Appointment = new Fragment_Appointment();
		}
		return fragment_Appointment;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_appointment, null);
		listView=(ListView) view.findViewById(R.id.listView);
		listView.setAdapter(new Adapter_ListView());
		return view;
	}
	class Adapter_ListView extends BaseAdapter{

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
			view=LayoutInflater.from(getActivity()).inflate(R.layout.item_listview_appointment, null);
			return view;
		}
		
	}
}
