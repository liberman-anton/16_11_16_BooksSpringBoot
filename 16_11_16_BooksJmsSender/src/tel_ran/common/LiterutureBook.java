package tel_ran.common;

public class LiterutureBook extends Book {
	String genre;

	public LiterutureBook() {
		super();
	}

	public LiterutureBook(long isbn, String title, float price, int publishYear, int pages, String publisher,
			String[] authors, String genre) {
		super(isbn, title, price, publishYear, pages, publisher, authors);
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "LiterutureBook [genre=" + genre + super.toString() + "]";
	}

	public String getGenre() {
		return genre;
	}
	
	
}
