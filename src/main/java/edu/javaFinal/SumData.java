package edu.javaFinal;

import java.util.ArrayList;

public class SumData {

	ArrayList<ChartData> chartArray;
	
	public SumData() {
		this.chartArray = new ArrayList<ChartData>();
	}

	public void addChart(ChartData data) {
		chartArray.add(data);
		
	}
	
}
