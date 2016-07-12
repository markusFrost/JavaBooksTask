package com.java.task.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.task.comparators.BooksComparator;
import com.java.task.models.Book;
import com.java.task.models.Reader;
import com.java.task.utils.HelpUtils;

public class BooksAnalyzer {
	
	private static BooksAnalyzer instance;
	
	private BooksAnalyzer(){}
	
	public static BooksAnalyzer getInstance(){
		
		if(instance == null){
			
			instance = new BooksAnalyzer();
		}
		
		return instance;
	}
	
	public void analyze(List<Book> listBooks, Reader reader, int daysCount){
		
		for(Book b : listBooks){
			
			b.calculateReadingTimeByReaderSpeed(reader.getReadingSpeed());
		}
		
		BooksComparator booksComparator = new BooksComparator();
		
		Collections.sort(listBooks, booksComparator);
		
		List<Book> resultList = new ArrayList<>();
		
		int sumDays = 0;
		int index = 0;
		
		while (sumDays < daysCount){
			
			Book b = listBooks.get(index);
			
			double overdueTime = b.getOverdueTime();
			
			if (sumDays + overdueTime > daysCount){
				break;
			}
			else{
				
				sumDays += overdueTime;
				resultList.add(b);
			}
			index++;
			
		}
		
		double residue = HelpUtils.calcResidue(listBooks, index);
		
		System.out.println(residue);
		
		int len = resultList.size();
		
		System.out.println(len);
	}

}
