package com.java.task.utils;

import java.util.List;

import com.java.task.models.Rent;

public class PrintResultsUtils {

	public static void printInfoAboutRent(List<Rent> listRent, 
			String dateFrom, String dateTo){
		
		System.out.print("Date start: " + dateFrom + "\t");
		System.out.println("Date end : " + dateTo);
		
		double sum = 0;
		
		for (Rent rent : listRent){
			
			sum +=  rent.getBook().getOverdueTime();
			
			System.out.println(rent.getReader().getName() + "\t" + 
					 rent.getBook().getAuthor() + "\t" + 
					 rent.getBook().getOverdueTime()
					);
		}
		
		System.out.println("_________________________________________");
		
		System.out.println("Result : " + sum + " rub");
	}
}
