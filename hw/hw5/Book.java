import java.util.*;
import java.util.Date;
/*Dounglan Cheung
 * 2.22.2020
 * CIS 351 Hw5
 */ 
//created by UML diagram
public class Book  {
	//final variables
	final static int AVAILABLE = 1;
	final static int UNAVAILABLE = 2;
	//global variables
	private String title;
	private String author;
	private String isbn;
	private int pages;
	private int year;
	private int status;
	
	private Date due;
	private Patron patron;

	public Book(String title, String author, String isbn, int year, int pages){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.pages = pages;
	}

	//sets book's status t AVAILABLE, patron and due are null
	public void checkin() {
		status = AVAILABLE;
		patron = null;
		due = null;
	}

	public void checkout(Patron patron, Date due) {
		status = UNAVAILABLE;
		this.patron = patron;
		this.due = due;
	}

	public boolean equals(Object other){
		if (other instanceof Book) {
			if (this.isbn.equals(isbn)){
				return true;
			}
			else {
				return false;
			}
		}
		else if (other instanceof String) {
			if (this.isbn.equals(other)){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}

	//getter methods
	public String getTitle() {
		return title;
	}	
	public String getAuthor() {
		return author;
	}
	public String getIsbn() {
		return isbn;
	}
	public int getPages() {
		return pages;
	}
	public int getYear() {
		return year;
	}
	public int getStatus() {
		return status;
	}
	public Date getDue() {
		return due;
	}
	public Patron getPatron() {
		return patron;
	}

	//gives the format for Books
	public String toString(){
		return String.format("Title: %s, Author: %s, ISBN: %s, Year: %d, Pages: %d", this.title, this.author, this.isbn, this.year, this.pages);
	}

}