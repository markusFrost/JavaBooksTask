package com.java.task.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.java.task.files.FilesHelper;
import com.java.task.models.Book;
import com.java.task.models.Reader;
import com.java.task.models.Rent;

public class FakeRentCreator {
	
	private String dateFrom = "05.06.2016";
	private int daysCount = 10;
	
	
	
	public FakeRentCreator(){}
	
	
	public void generate(){
		
		Reader reader;
		List<Reader> listReader = new ArrayList<>();
		
		for (int i = 1; i <= 200; i++){
			
			reader = new Reader();
			
			reader.setName("Reader " + i);
			reader.setReadingSpeed( (i * 10 + 100));
			
			listReader.add(reader);
		}
		
		Book book;
		List<Book> listBook = new ArrayList<>();
		
		for(int i = 1; i <= 1000; i++){
			
			book = new Book();
			
			book.setAuthor("Author " + i);
			book.setNumberOfPages(i * 100 + 200);
			book.setOverdueTime(i + 10);
			book.setTitle("Title " + 1);
			book.setYear(1700 + i);
			
			listBook.add(book);
		}
		
		int index = 0;
		
		List<Rent> listRent = new ArrayList<>();
		
		for (int i = 1; i <= 30; i++){
			
			String date = "";
			
			if (i < 10){
				
				date = "0" + i + ".06.2016";
			}
			else{
				
				date = i + ".06.2016";
			}
			
			Random rand = new Random();
			
			int count = rand.nextInt(5);
			
			for (int j = index; j <= index + count; j++){
				
				Rent rent = new Rent();
			    
				Reader r = listReader.get(j);
				Book b = listBook.get(j);
				
				rent.setReader(r);
				rent.setBook(b);
				
				rent.setDateReturn(date);
				rent.setDateTake("date " + i);
				rent.setFine(i + 5);
				
				listRent.add(rent);
			}
			
			index += count;
		}
		
		FilesHelper.getInstance().saveRentsInFile(listRent);
	}


	public String getDateFrom() {
		return dateFrom;
	}


	public int getDaysCount() {
		return daysCount;
	}
	
	

	


	
	

}
