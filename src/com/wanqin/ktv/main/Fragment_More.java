/**   
 * 文件名：Fragment_Find.java 
 * 类名称：Fragment_Find   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-9-7 上午10:50:40  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-9-7 上午10:50:40   
 * 修改备注：   
 */
package com.wanqin.ktv.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wanqin.ktv.R;
import com.wanqin.ktv.chat.Activity_ChatInSingleShop;
import com.wanqin.ktv.demo.Activity_About;
import com.wanqin.ktv.demo.Activity_AppointMent;
import com.wanqin.ktv.demo.Activity_GameRule;
import com.wanqin.ktv.demo.Activity_MyGift;
import com.wanqin.ktv.demo.Activity_MyMoney;
import com.wanqin.ktv.demo.Activity_Nominate;
import com.wanqin.ktv.demo.Activity_ScoreMall;
import com.wanqin.ktv.demo.Activity_caller;
import com.wanqin.ktv.demo.Activity_join;
import com.wanqin.ktv.person.Activity_MyOrder;
import com.wanqin.ktv.person.Activity_PersonCenter;
import com.wanqin.ktv.person.Activity_Setting;

/**
 * @ClassName: Fragment_Find
 * @Description: TODO(*)
 * @author 诸葛飞扬。JJ
 * @date 2014-9-7 上午10:50:40
 * 
 */
public class Fragment_More extends Fragment implements OnClickListener {
	static Fragment_More fragment_more;
	private LinearLayout wodeqianbao, gerenzhuye, wodedingdan, hejiuzhuxing,
			zhaoxiannashi, shangjiajiameng, wodeliwu, jifenshangcheng,
			zuijinfangke, jingpintuijian, shezhi, guanyuwomen;
	private ImageView party_ImageView;
	public synchronized static Fragment_More getInstance() {
		if (fragment_more == null) {
			fragment_more = new Fragment_More();
		}
		return fragment_more;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_more3, null);
		party_ImageView=(ImageView) view.findViewById(R.id.party_ImageView);
		wodeqianbao = (LinearLayout) view.findViewById(R.id.wodeqianbao);
		gerenzhuye = (LinearLayout) view.findViewById(R.id.gerenzhuye);
		wodedingdan = (LinearLayout) view.findViewById(R.id.wodedingdan);
		hejiuzhuxing = (LinearLayout) view.findViewById(R.id.hejiuzhuxing);
		zhaoxiannashi = (LinearLayout) view.findViewById(R.id.zhaoxiannashi);
		shangjiajiameng = (LinearLayout) view
				.findViewById(R.id.shangjiajiameng);
		wodeliwu = (LinearLayout) view.findViewById(R.id.wodeliwu);
		jifenshangcheng = (LinearLayout) view
				.findViewById(R.id.jifenshangcheng);
		zuijinfangke = (LinearLayout) view.findViewById(R.id.zuijinfangke);
		jingpintuijian = (LinearLayout) view.findViewById(R.id.jingpintuijian);
		shezhi = (LinearLayout) view.findViewById(R.id.shezhi);
		guanyuwomen = (LinearLayout) view.findViewById(R.id.guanyuwomen);
		wodeqianbao.setOnClickListener(this);
		gerenzhuye.setOnClickListener(this);
		wodedingdan.setOnClickListener(this);
		hejiuzhuxing.setOnClickListener(this);
		zhaoxiannashi.setOnClickListener(this);
		shangjiajiameng.setOnClickListener(this);
		wodeliwu.setOnClickListener(this);
		jifenshangcheng.setOnClickListener(this);
		zuijinfangke.setOnClickListener(this);
		jingpintuijian.setOnClickListener(this);
		shezhi.setOnClickListener(this);
		guanyuwomen.setOnClickListener(this);
		party_ImageView.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.wodeqianbao:
			Intent wodeqianbao=new Intent(getActivity(), Activity_MyMoney.class);
			startActivity(wodeqianbao);
			break;
		case R.id.gerenzhuye:
			Intent gerenzhuye=new Intent(getActivity(), Activity_PersonCenter.class);
			startActivity(gerenzhuye);
			break;
		case R.id.wodedingdan:
			Intent wodedingdan=new Intent(getActivity(), Activity_MyOrder.class);
			startActivity(wodedingdan);
			break;
		case R.id.hejiuzhuxing:
			Intent hejiuzhuxing=new Intent(getActivity(), Activity_GameRule.class);
			startActivity(hejiuzhuxing);
			
			break;
		case R.id.zhaoxiannashi:
			Intent zhaoxiannashi=new Intent(getActivity(), Activity_ChatInSingleShop.class);
			startActivity(zhaoxiannashi);
			break;
		case R.id.shangjiajiameng:
			Intent shangjiajiameng=new Intent(getActivity(), Activity_join.class);
			startActivity(shangjiajiameng);
			break;
		case R.id.wodeliwu:
			Intent wodeliwu=new Intent(getActivity(), Activity_MyGift.class);
			startActivity(wodeliwu);
			break;
		case R.id.jifenshangcheng:
			Intent jifenshangcheng=new Intent(getActivity(), Activity_ScoreMall.class);
			startActivity(jifenshangcheng);
			break;
		case R.id.zuijinfangke:
			Intent zuijinfangke=new Intent(getActivity(), Activity_caller.class);
			startActivity(zuijinfangke);
			break;
		case R.id.jingpintuijian:
			Intent jingpintuijian=new Intent(getActivity(), Activity_Nominate.class);
			startActivity(jingpintuijian);
			break;
		case R.id.shezhi:
			Intent shezhi=new Intent(getActivity(), Activity_Setting.class);
			startActivity(shezhi);
			
			break;
		case R.id.guanyuwomen:
			Intent guanyuwomen=new Intent(getActivity(), Activity_About.class);
			startActivity(guanyuwomen);
			break;
		case R.id.party_ImageView:
			Intent party_ImageView=new Intent(getActivity(), Activity_AppointMent.class);
			startActivity(party_ImageView);
			break;
		}
	}
	@Override
	public void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		super.startActivity(intent);
		getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}
}
