package edu.javaFinal;

import java.util.ArrayList;
import java.util.HashMap;

public class ChartData {
	private String fileNum;
	private String title;
	private String chartNum;
	private String chartType;
	private String chartCaption;
	private String chartPage;
	private String fullInfo;

	// String category1 = "제목,요약문(300자 내외),핵심어(keyword,쉼표로 구분),조회날짜," + "실제자료조회 출처
	// (웹 자료링크),원출처 (기관명 등),제작자(Copyright 소유)";
	// 짝수 데이
	public ChartData(String info, String key) {
		String[] temp = info.split(",");
		this.fileNum = key;
		this.title = temp[0];
		this.chartNum = temp[1];
		this.chartType = temp[2];
		this.chartCaption = temp[3];
		this.chartPage = temp[4];
		this.fullInfo = merge();
	}

	public String merge() {
		String info = this.fileNum + "," + this.title + "," + this.chartNum + "," + this.chartType + ","
				+ this.chartCaption + "," + this.chartPage;
		return info;
	}

	public String getFullInfo() {
		return fullInfo;
	}

	public void setFullInfo(String fullInfo) {
		this.fullInfo = fullInfo;
	}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChartNum() {
		return chartNum;
	}

	public void setChartNum(String chartNum) {
		this.chartNum = chartNum;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public String getChartCaption() {
		return chartCaption;
	}

	public void setChartCaption(String chartCaption) {
		this.chartCaption = chartCaption;
	}

	public String getChartPage() {
		return chartPage;
	}

	public void setChartPage(String chartPage) {
		this.chartPage = chartPage;
	}

}
