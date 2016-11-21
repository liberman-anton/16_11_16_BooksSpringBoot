package tel_ran.books.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import tel_ran.books.entities.Author;
import tel_ran.books.entities.Book;
import tel_ran.books.entities.Buyer;
import tel_ran.books.entities.Deal;
import tel_ran.books.entities.Publisher;

public class BooksOrm {
	
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;

	@Transactional
	public boolean addAuthor(Author author){
		if(author == null || em.find(Author.class, author.getName()) != null)
			return false;
		em.persist(author);
		return true;
	}
	@Transactional
	public boolean addPublisher(Publisher publisher){
		if(publisher == null || em.find(Publisher.class, publisher.getName()) != null)
			return false;
		em.persist(publisher);
		return true;
	}
	@Transactional
	public boolean addBook(Book book, Set<String> authorNames, String publisherName) throws Exception{
		if(em.find(Book.class, book.getIsbn()) != null)
			return false;
		Set<Author> authors = getAuthors(authorNames);
		Publisher publisher = getPublisher(publisherName);
		book.setAuthors(authors);
		book.setPublisher(publisher);
		em.persist(book);
		return true;
	}
	
	@Transactional
	public boolean addBuyer(Buyer buyer){
		if(buyer == null || em.find(Buyer.class, buyer.getIdentity()) != null)
			return false;
		em.persist(buyer);
		return true;
	}
	
	@Transactional
	public boolean addDeal(long isbn, int discount, Date date, long idBuyer){
		Buyer buyer = em.find(Buyer.class, idBuyer);
		if(buyer == null)
			return false;
		Deal deal = new Deal(discount, date);
		deal.setBuyer(buyer);
		em.persist(deal);
		
		Book book = em.find(Book.class, isbn);
		em.refresh(book);
		if(book == null)
			return false;
		Set<Deal> deals = book.getDeals();
		deals.add(deal);
		return true;	
	}
	
	private Publisher getPublisher(String publisherName) throws PublisherNotFoundException {
		Publisher res = em.find(Publisher.class, publisherName);
		if(res == null)
			throw new PublisherNotFoundException(publisherName);
		return res;
	}
	private Set<Author> getAuthors(Set<String> authorNames) throws AuthorNotFoundException {
		Set<Author> res = new LinkedHashSet<>();
		for(String name : authorNames){
			Author author = em.find(Author.class, name);
			if(author == null)
				throw new AuthorNotFoundException(name);
			res.add(author);
		}
		return res;
	}
	public int getPublishYearOfBook(long isbnOfBook) {
		Query query = em.createQuery(String.format("select b.publishYear from Book b where b.isbn=%1$d", isbnOfBook));
		int res = (int) query.getSingleResult();
		return res;
	}
	public String query(String str) {
		Query query = em.createQuery(str);
		String res = query.getResultList().toString();
		return res;
	}
	public Book getBook(long isbn) {
		return em.find(Book.class, isbn);
	}
}
