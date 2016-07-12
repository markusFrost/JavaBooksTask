package com.java.task.utils;

import java.util.ArrayList;
import java.util.List;

import com.java.task.models.Book;
import com.java.task.models.Reader;

public class HelpUtils {
	
	
	public static void printResult(List<Book> inputList, List<Book> outPutList, Reader reader){
		
		List<Book> holdBooksList = getHoldBooks(inputList, outPutList);
		
		System.out.println("Program estimates library overdue fines" + "\n" + 
"Enter number of days to due date: " + new FakeHelper().getDaysCount());
		
		System.out.println("Reader " +  reader.getName() +
				" has read " + outPutList.size() + 
				" books and holds " +  (inputList.size() - outPutList.size()) 
				+ " book:");
		
		for(Book b : outPutList){
			
			System.out.println("(read) "  + b.getTitle()+ " - " 
			+ b.getAuthor()+ " - number of pages: " + b.getNumberOfPages());
		}
		
		for(Book b : holdBooksList){
			
			System.out.println("(holds) "  + b.getTitle()+ " - " 
			+ b.getAuthor()+ " - overdue fine: " + b.getOverdueTime());
		}
		
		System.out.println("Total overdue fine: " + calcResidue(holdBooksList));
		
		
	}
	
	private static List<Book> getHoldBooks(List<Book> inputList, List<Book> outPutList){
		
		boolean fl = true;
		
		List<Book> holdBooksList = new ArrayList<>();
		
		for(Book bOut : inputList){
			
			for(Book bIn : outPutList){
				
				if (bOut.getAuthor().equals(bIn.getAuthor())){
					fl = false;
				}
			}
			if(fl){
				holdBooksList.add(bOut);
			}
			fl = true;
		}
		
		return holdBooksList;
	}

	public static double calcResidue(List<Book> list, int index) {

		double sum = 0;

		if (index < list.size()) {
			for (int i = index; i < list.size(); i++) {

				sum += list.get(i).getOverdueTime();
			}
		}

		return sum;
	}
	
	public static double calcResidue(List<Book> list) {

		double sum = 0;

			for (int i = 0; i < list.size(); i++) {

				sum += list.get(i).getOverdueTime();
			
		}

		return sum;
	}

	public static int calcResidueDays(List<Book> list, int daysCount) {

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {

			sum += list.get(i).getReadindTime();
		}

		return (daysCount - sum);
	}

}
