package tel_ran.books.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tel_ran.books.dao.BooksOrm;
import tel_ran.books.entities.Book;


@SpringBootApplication
@ImportResource("classpath:beans.xml")
@RestController
public class BooksService {
	
	@Autowired
	BooksOrm booksOrm;
	
	@RequestMapping(value = "query")
	public String query(String query){
		String res = booksOrm.query(query);
		return res;
	}
	
	@RequestMapping(value = "bestseller")
	public String bestseller(){
		String res = booksOrm.query("select b.isbn from Book b where size(b.deals)>7");
		return res;
	}
	
	@RequestMapping(value = "get_book")
	public Map<String,Object> getPerson(long isbn){
		Map<String,Object> res = new LinkedHashMap<>();
		Book book = booksOrm.getBook(isbn);
		if(book == null){
			res.put("status", "error");
			res.put("data", "book not found " + isbn);
		}
		else {
			res.put("status", "success");
			res.put("data", book);
		}
		return res;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BooksService.class, args);
	}
}
