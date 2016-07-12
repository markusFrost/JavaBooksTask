package com.java.task.models;

public class Book {

	private String title;
	
	private String author;
	
	private int year;
	
	private int numberOfPages;
	
	private double overdueTime;
	
	private double readindTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getOverdueTime() {
		return overdueTime;
	}

	public void setOverdueTime(double overdueTime) {
		this.overdueTime = overdueTime;
	}
	
	public void calculateReadingTimeByReaderSpeed(int speed){
		
		readindTime =  (double)(numberOfPages / speed); 
	}

	public double getReadindTime() {
		return readindTime;
	}
	
	
	
	
	
}
