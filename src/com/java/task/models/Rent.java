package com.java.task.models;

public class Rent {

	private Reader reader;
	
	private Book book;
	
	private String dateTake;
	
	private String dateReturn;
	
	private double fine;
	
	public Rent(){}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDateTake() {
		return dateTake;
	}

	public void setDateTake(String dateTake) {
		this.dateTake = dateTake;
	}

	public String getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}
	
	
}
