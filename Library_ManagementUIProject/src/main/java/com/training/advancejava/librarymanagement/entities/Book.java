package com.training.advancejava.librarymanagement.entities;

import java.time.LocalDate;




public class Book {

	private int bookCode;
	
	private String bookName;
	
	private String bookAuthor;
	
	private LocalDate bookDate;
	
	

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookDate="
				+ bookDate + "]";
	}

	public Book(int bookCode, String bookName, String bookAuthor, LocalDate bookDate) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDate = bookDate;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
}
