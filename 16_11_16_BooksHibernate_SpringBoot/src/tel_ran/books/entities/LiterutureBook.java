package tel_ran.books.entities;

import javax.persistence.Entity;

@Entity
public class LiterutureBook extends Book {
	String genre;

	public LiterutureBook(long isbn, String title, float price, int publishYear, int pages, String genre) {
		super(isbn, title, price, publishYear, pages);
		this.genre = genre;
	}

	public LiterutureBook() {
		super();
	}

	@Override
	public String toString() {
		return "LiterutureBook [genre=" + genre + ", toString()=" + super.toString() + "]";
	}

	public String getGenre() {
		return genre;
	}
	
	
}
