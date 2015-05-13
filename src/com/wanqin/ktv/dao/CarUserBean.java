package com.wanqin.ktv.dao;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "caruserbean")
public class CarUserBean implements Serializable {
	@DatabaseField(generatedId = true)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartLongtitude() {
		return startLongtitude;
	}

	public void setStartLongtitude(String startLongtitude) {
		this.startLongtitude = startLongtitude;
	}

	public String getStartLatitude() {
		return startLatitude;
	}

	public void setStartLatitude(String startLatitude) {
		this.startLatitude = startLatitude;
	}

	public String getStartPic() {
		return startPic;
	}

	public void setStartPic(String startPic) {
		this.startPic = startPic;
	}

	public int getStartMileage() {
		return startMileage;
	}

	public void setStartMileage(int startMileage) {
		this.startMileage = startMileage;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndLongtitude() {
		return endLongtitude;
	}

	public void setEndLongtitude(String endLongtitude) {
		this.endLongtitude = endLongtitude;
	}

	public String getEndLatitude() {
		return endLatitude;
	}

	public void setEndLatitude(String endLatitude) {
		this.endLatitude = endLatitude;
	}

	public String getEndPic() {
		return endPic;
	}

	public void setEndPic(String endPic) {
		this.endPic = endPic;
	}

	public int getEndMileage() {
		return endMileage;
	}

	public void setEndMileage(int endMileage) {
		this.endMileage = endMileage;
	}

	public String getCarNumberID() {
		return carNumberID;
	}

	public void setCarNumberID(String carNumberID) {
		this.carNumberID = carNumberID;
	}

	@DatabaseField
	private String startTime; // �ϳ�ʱ��
	@DatabaseField
	private String startLongtitude; // �ϳ�����
	@DatabaseField
	private String startLatitude; // �ϳ�γ��
	@DatabaseField
	private String startPic; // �ϳ�����ͼ��ת��BASE64�ַ�����
	@DatabaseField
	private int startMileage; // �ϳ�ʱ��̱�����
	@DatabaseField
	private String endTime; // �³�ʱ��
	@DatabaseField
	private String nowTime; // ��ǰʱ��

	public String getNowTime() {
		return nowTime;
	}

	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}

	@DatabaseField
	private String endLongtitude; // �³�����
	@DatabaseField
	private String endLatitude; // �³�γ��
	@DatabaseField
	private String endPic; // �³�����ͼ��ת��BASE64�ַ�����
	@DatabaseField
	private int endMileage; // �³�ʱ����̱�����
	@DatabaseField
	private String carNumberID; // ���ƺ�id
	@DatabaseField
	private String carNumber; // ���ƺ�



	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@DatabaseField
	private String update;
	@DatabaseField
	private String colorupdate;

	public String getColorupdate() {
		return colorupdate;
	}

	public void setColorupdate(String colorupdate) {
		this.colorupdate = colorupdate;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

}
