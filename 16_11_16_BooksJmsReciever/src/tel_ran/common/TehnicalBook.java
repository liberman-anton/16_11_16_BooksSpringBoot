package tel_ran.common;

public class TehnicalBook extends Book {
	String subject;
	int edition;
	
	public TehnicalBook(long isbn, String title, float price, int publishYear, int pages, String publisher,
			String[] authors, String subject, int edition) {
		super(isbn, title, price, publishYear, pages, publisher, authors);
		this.subject = subject;
		this.edition = edition;
	}
	public TehnicalBook() {
		super();
	}
	public String getSubject() {
		return subject;
	}
	public int getEdition() {
		return edition;
	}
	@Override
	public String toString() {
		return "TehnicalBook [subject=" + subject + ", edition=" + edition + super.toString() + "]";
	}
	
	
}
