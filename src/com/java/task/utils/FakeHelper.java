package com.java.task.utils;

import java.util.ArrayList;
import java.util.List;

import com.java.task.models.Book;
import com.java.task.models.Reader;

public class FakeHelper {
	
	private Reader reader;
	private List<Book> listBooks;
    private int daysCount;
	
	public FakeHelper(){
		
		generateFakeData();
	}
	
	

	public Reader getReader() {
		return reader;
	}




	public List<Book> getListBooks() {
		return listBooks;
	}
	
	




	public int getDaysCount() {
		return daysCount;
	}



	private void generateFakeData() {

		this.daysCount = 13;
		
		Reader reader = new Reader();
		reader.setName("John Smith");
		reader.setReadingSpeed(90);
		
		this.reader = reader;

		List<Book> listBooks = new ArrayList<Book>();
		Book b;

		// --------------------------------

		b = new Book();
		b.setAuthor("Jack London");
		b.setTitle("White Fang");
		b.setNumberOfPages(215);
		b.setOverdueTime(2);

		listBooks.add(b);

		// --------------------------------

		b = new Book();
		b.setAuthor("Jonathan Swift");
		b.setTitle("Gulliver’s Travels");
		b.setNumberOfPages(352);
		b.setOverdueTime(3);

		listBooks.add(b);

		// --------------------------------

		b = new Book();
		b.setAuthor("Magda Szabo");
		b.setTitle("The Door");
		b.setNumberOfPages(400);
		b.setOverdueTime(4);

		listBooks.add(b);

		// --------------------------------

		b = new Book();
		b.setAuthor("JRR Tolkien");
		b.setTitle("The Lord of the Rings");
		b.setNumberOfPages(700);
		b.setOverdueTime(6);

		listBooks.add(b);

		// --------------------------------

		b = new Book();
		b.setAuthor("Steven Erikson");
		b.setTitle("A Tale of the Malazan Book of the Fallen");
		b.setNumberOfPages(300);
		b.setOverdueTime(3);

		listBooks.add(b);

		// --------------------------------

		b = new Book();
		b.setAuthor("Brandon Sanderson");
		b.setTitle("The Stormlight Archive");
		b.setNumberOfPages(500);
		b.setOverdueTime(5);

		listBooks.add(b);
		
		this.listBooks = listBooks;

	}

}
