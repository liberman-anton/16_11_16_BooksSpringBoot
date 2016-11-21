package tel_ran.books.controller;


import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.books.dao.BooksAuthorsPublishersOrm;
import tel_ran.books.entities.*;

public class RandomBooksCreation {

	private static final int N_AUTHORS = 20;
	private static final int N_STREETS = 10;
	private static final int N_CITIES = 60;
	private static final int N_BOOKS = 100;
	private static final int N_PUBLISHERS = 3;
	private static final int N_EDITIONS = 5;
	private static final int N_BUILDINGS = 100;
	private static final int N_APPARTAMENTS = 200;
	private static final int N_BUYERS = 500;
	private static final int N_DEALS = 300;
	
	static BooksAuthorsPublishersOrm booksOrm;
	static Random gen = new Random();
	static long isbn = 0;
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		booksOrm = ctx.getBean(BooksAuthorsPublishersOrm.class);
		try {
			createRandomBooks();
			createBuyers();
			createDeals();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}

	private static void createDeals() {
		for(int i = 0; i< N_DEALS; i++){
			long isbnOfBook = (long) (1 + gen.nextInt(N_BOOKS - 1));
			booksOrm.addDeal(isbnOfBook, gen.nextInt(90), getDateOfDeal(isbnOfBook), 
					(long)(1000000 + gen.nextInt(N_BUYERS)));
		}
	}

	private static Date getDateOfDeal(long isbnOfBook) {
		int publishYear = booksOrm.getPublishYearOfBook(isbnOfBook);
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, publishYear + gen.nextInt(2015 - publishYear));
		calendar.set(Calendar.DAY_OF_YEAR, gen.nextInt(365));
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return new Date(calendar.getTimeInMillis());
	}

	private static void createBuyers() {
		for(int i = 0; i< N_BUYERS; i++){
			booksOrm.addBuyer(new Buyer((long)(1000000 + i), 
					"Buyer" + gen.nextInt(N_BUYERS / 2), 
					1940 + gen.nextInt(55), getRandomAddress(), 
					getRandomPhoneNumber(), getRandomMail()));
		}
	}

	private static String getRandomMail() {
		return "buyer_mail" + gen.nextInt(1000) + "@google.com";
	}

	private static String getRandomPhoneNumber() {
		return "0" + (500 + gen.nextInt(400)) + "-" + 
						(500 + gen.nextInt(400)) + "-" + (500 + gen.nextInt(400));
	}

	private static void createRandomBooks() throws Exception {
		createAuthors();
		createPublishers();
		for(int i = 0; i < N_BOOKS; i++){
			createRandomBook();
		}
	}

	private static void createRandomBook() throws Exception {
		if(gen.nextInt(2) == 1)
		booksOrm.addBook(new LiterutureBook(++isbn, getRandomTitle(), getRandomPrice(), 
				getRandomPublishYear(), getRandomNumberPages(), getRandomGenre()),
				getAuthorNames(), getPublisherName());
		else
			booksOrm.addBook(new TehnicalBook(++isbn, getRandomTitle(), getRandomPrice(), 
					getRandomPublishYear(), getRandomNumberPages(), 
					getRandomSubject(), gen.nextInt(N_EDITIONS)),
					getAuthorNames(), getPublisherName());
	}

	private static String getRandomSubject() {
		return "subject" + gen.nextInt(N_BOOKS / 10);
	}

	private static String getRandomGenre() {
		return "genre" + gen.nextInt(N_BOOKS / 10);
	}

	private static int getRandomNumberPages() {
		return 100 + gen.nextInt(500);
	}

	private static int getRandomPublishYear() {
		return 2000 + gen.nextInt(15);
	}

	private static Set<String> getAuthorNames() {
		Set<String> res = new LinkedHashSet<>();
		int nAuthors = 1 + gen.nextInt(5);
		for(int i = 0; i < nAuthors; i++)
			res.add("author" + gen.nextInt(N_AUTHORS));
		return res;
	}

	private static String getPublisherName() {
		return "publisher" + gen.nextInt(N_PUBLISHERS);
	}

	private static float getRandomPrice() {
		return 100.5f + gen.nextInt(500);
	}

	private static String getRandomTitle() {
		return "title" + gen.nextInt(N_BOOKS);
	}

	private static void createPublishers() {
		for(int i = 0; i < N_PUBLISHERS; i++){
			booksOrm.addPublisher(new Publisher("publisher" + i, getRandomAddress()));
		}
	}

	private static void createAuthors() {
		for(int i = 0; i< N_AUTHORS; i++){
			booksOrm.addAuthor(new Author("author" + i, new Date(getRandomBirthdate())));
		}
	}

	private static long getRandomBirthdate() {
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_YEAR, - 10 - gen.nextInt(300));
		calendar.add(Calendar.YEAR, - gen.nextInt(14));
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return  calendar.getTimeInMillis();
	}

	private static Address getRandomAddress() {
		return new Address("Street" + gen.nextInt(N_STREETS), "City" + gen.nextInt(N_CITIES), 
				gen.nextInt(N_BUILDINGS), gen.nextInt(N_APPARTAMENTS));
				
	}

}
