package tel_ran.common;

import java.util.*;

public class Book {
	long isbn;
	String title;
	float price;
	int publishYear;
	int pages;
	String publisher;
	String[] authors;
	
	public Book() {
		super();
	}

	public Book(long isbn, String title, float price, int publishYear, 
			int pages, String publisher, String[] authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publishYear = publishYear;
		this.pages = pages;
		this.publisher = publisher;
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "isbn=" + isbn + ", title=" + title + ", price=" + price + ", publishYear=" + publishYear
				+ ", pages=" + pages + ", publisher=" + publisher + ", authors=" + Arrays.toString(authors);
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public float getPrice() {
		return price;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public int getPages() {
		return pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
}
