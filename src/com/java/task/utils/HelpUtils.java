package com.java.task.utils;

import java.util.List;

import com.java.task.models.Book;

public class HelpUtils {
	
	public static double calcResidue(List<Book> list, int index){
		
		double sum = 0;
		
		if(index < list.size()){
			for(int i = index; i < list.size(); i++){
				
				sum += list.get(i).getOverdueTime();
			}
		}
		
		return sum;
	}

}
