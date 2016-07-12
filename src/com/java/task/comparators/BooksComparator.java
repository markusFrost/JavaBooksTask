package com.java.task.comparators;

import java.util.Comparator;

import com.java.task.models.Book;

public class BooksComparator implements Comparator<Book> {

	 @Override
	    public int compare(Book b1, Book b2) {
	    	
	       if (b1.getOverdueTime() < b2.getOverdueTime()){
	    	   
	    	   return 1;
	       }
	       else if(b1.getOverdueTime() > b2.getOverdueTime()){
	    	   
	    	   return -1;
	       }
	       else{
	    	   
	    	   return 0;
	       }
	    }

}
