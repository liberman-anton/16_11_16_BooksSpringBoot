package tel_ran.recievers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import tel_ran.common.Book;

@Component
public class RecieverListener {

	@JmsListener(destination = "tel_ran_books")
	public void readBook(Book book){
		System.out.println(book);
	}
}
