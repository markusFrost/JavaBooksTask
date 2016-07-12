package com.java.task.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.task.comparators.BooksComparator;
import com.java.task.models.Book;
import com.java.task.models.Reader;
import com.java.task.utils.HelpUtils;
import com.sun.javafx.jmx.MXExtension;

public class BooksAnalyzer {

	private static BooksAnalyzer instance;

	private BooksAnalyzer() {
	}

	public static BooksAnalyzer getInstance() {

		if (instance == null) {

			instance = new BooksAnalyzer();
		}

		return instance;
	}

	public void analyze(List<Book> listInputBooks, Reader reader, int daysCount) {

		for (Book b : listInputBooks) {

			b.calculateReadingTimeByReaderSpeed(reader.getReadingSpeed());
		}

		BooksComparator booksComparator = new BooksComparator();

		Collections.sort(listInputBooks, booksComparator);

		List<Book> resultList = new ArrayList<>();

		int sumDays = 0;
		int index = 0;

		while (sumDays < daysCount) {

			Book b = listInputBooks.get(index);

			double overdueTime = b.getOverdueTime();

			if (sumDays + overdueTime > daysCount) {
				break;
			} else {

				sumDays += overdueTime;
				resultList.add(b);
			}
			index++;

		}

		// ---------
		double SumOverDue = HelpUtils.calcResidue(listInputBooks);
		
		double reduce = HelpUtils.calcResidue(resultList);
		
		
		
		System.out.println(SumOverDue);
		System.out.println("reduce = " + (SumOverDue - reduce));
		
		List<Double> resultOverDueList = new ArrayList<>();
		
		for(int i = 0; i < resultList.size(); i++){
			
			double price = calculateOverDueTime(resultList, listInputBooks,  daysCount, i);
			
			resultList.size();
			
			double resultValue  = SumOverDue - price;
			
			System.out.println(resultValue);
			
			resultOverDueList.add(resultValue);
		}
		
		
		int minIndex = 0;
		double min = resultOverDueList.get(0);
		
		for(int i = 1; i < resultOverDueList.size(); i++){
			
			
			if (resultOverDueList.get(i) < min){
				
				min = resultOverDueList.get(i);
				minIndex = i;
			}
		}
		
		List<Book> outPutList = getResultBooksList(resultList, listInputBooks,  daysCount, minIndex);
		
		System.out.println(outPutList.size());
		
		System.out.println(min);

		

	}
	
	

	private double calculateOverDueTime(List<Book> resultList1, List<Book> listInputBooks1, int daysCount, int resIndex) {

		List<Book> resultList = new ArrayList<>();
		resultList.addAll(resultList1);
		
		List<Book> listInputBooks = new ArrayList<>();
		listInputBooks = listInputBooks1;
		
		double overdueTime = resultList.get(resIndex).getOverdueTime();

		int daysRedue = HelpUtils.calcResidueDays(resultList, daysCount);

		int countDays = (int) (resultList.get(resIndex).getReadindTime() + daysRedue);
		
		int index = resultList.size();
		
		double price = 0;
		int readingTime = 0;
		
		List<Book> currentList = new ArrayList<>();
		
		for(int i = index; i < listInputBooks.size(); i++){
			
			Book b = listInputBooks.get(i);
			
			if (readingTime + b.getReadindTime() > countDays){
				
				if (price + b.getOverdueTime() > overdueTime){
					
					resultList.remove(resIndex);
					resultList.addAll(currentList);
					
					break;
				}
			}
			else{
				
				readingTime += b.getReadindTime();
				price += b.getOverdueTime();
				
				currentList.add(b);
			}
		}
		
		double resultOverDue = HelpUtils.calcResidue(resultList);
		
		//System.out.println(resultOverDue);
		
		return resultOverDue;
	}
	
	private List<Book> getResultBooksList(List<Book> resultList1, List<Book> listInputBooks1, int daysCount, int resIndex) {

		List<Book> resultList = new ArrayList<>();
		resultList.addAll(resultList1);
		
		List<Book> listInputBooks = new ArrayList<>();
		listInputBooks = listInputBooks1;
		
		double overdueTime = resultList.get(resIndex).getOverdueTime();

		int daysRedue = HelpUtils.calcResidueDays(resultList, daysCount);

		int countDays = (int) (resultList.get(resIndex).getReadindTime() + daysRedue);
		
		int index = resultList.size();
		
		double price = 0;
		int readingTime = 0;
		
		List<Book> currentList = new ArrayList<>();
		
		for(int i = index; i < listInputBooks.size(); i++){
			
			Book b = listInputBooks.get(i);
			
			if (readingTime + b.getReadindTime() > countDays){
				
				if (price + b.getOverdueTime() > overdueTime){
					
					resultList.remove(resIndex);
					resultList.addAll(currentList);
					
					break;
				}
			}
			else{
				
				readingTime += b.getReadindTime();
				price += b.getOverdueTime();
				
				currentList.add(b);
			}
		}
		
		double resultOverDue = HelpUtils.calcResidue(resultList);
		
		//System.out.println(resultOverDue);
		
		return resultList;
	}

}
