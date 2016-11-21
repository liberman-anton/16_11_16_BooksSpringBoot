package tel_ran.books.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.*;

@Entity
abstract public class Book {
	@Id
	long isbn;
	String title;
	float price;
	int publishYear;
	int pages;
	@ManyToOne
	Publisher publisher;
	@ManyToMany
	Set<Author> authors;
	@OneToMany
	Set<Deal> deals;
	
	public Book() {
		super();
	}

	public Book(long isbn, String title, float price, int publishYear, int pages) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publishYear = publishYear;
		this.pages = pages;
		this.deals = new HashSet<Deal>();
	}

	@Override
	public String toString() {
		return "isbn=" + isbn + ", title=" + title + ", price=" + price + ", publishYear=" + publishYear
				+ ", pages=" + pages + ", publisher=" + publisher + ", authors=" + authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
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

	public Set<Deal> getDeals() {
		return deals;
	}

	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}
	
}
