package com.java.task.calc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.java.task.models.Rent;
import com.java.task.utils.HelpUtils;
import com.java.task.utils.PrintResultsUtils;
import com.sun.javafx.binding.StringFormatter;

public class RentAnalyzer {
	
	private static RentAnalyzer instance;

	private RentAnalyzer() {
	}

	public static RentAnalyzer getInstance() {

		if (instance == null) {

			instance = new RentAnalyzer();
		}

		return instance;
	}
	
	public void analyze(List<Rent> listRent, String data,  int daysCount){
		
		List<Rent> listResults = new ArrayList<>();
		
		long startTime = HelpUtils.convertStringToTimeMills(data);
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTimeInMillis(startTime);
		
		calendar.add(Calendar.DATE, daysCount);
				
		
		
		StringBuilder sb = new StringBuilder();
		
		if (calendar.get(Calendar.DAY_OF_MONTH) < 10){
			
			sb.append("0");
			sb.append(calendar.get(Calendar.DAY_OF_MONTH));
		}
		else{
			
			sb.append(calendar.get(Calendar.DAY_OF_MONTH));
		}
		
		sb.append(".");
		
		if (calendar.get(Calendar.MONTH) < 10){
			
			sb.append("0");
			sb.append(calendar.get(Calendar.MONTH) + 1);
		}
		else{
			
			sb.append(calendar.get(Calendar.MONTH) + 1);
		}
		sb.append(".");
		sb.append(calendar.get(Calendar.YEAR));
		
		String endDate = sb.toString();
		
		long endTime = HelpUtils.convertStringToTimeMills(endDate);
		
		for (Rent rent : listRent){
			
			long time = HelpUtils.convertStringToTimeMills(rent.getDateReturn());
			
			if( time >= startTime && time <= endTime){
				
				listResults.add(rent);
			}
		}
		
		int len = listResults.size();
		
		PrintResultsUtils.printInfoAboutRent(listResults, data, sb.toString());
	}

}
