package tel_ran.senders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.*;

import tel_ran.common.Book;
import tel_ran.common.LiterutureBook;


@SpringBootApplication
public class SenderJms {
	
	@Bean
	public MessageConverter createMessageConverter(){
		MappingJackson2MessageConverter res = new MappingJackson2MessageConverter();
		res.setTargetType(MessageType.TEXT);
		res.setTypeIdPropertyName("_type");//type - same in reciever
		return res;
	}
	
	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(SenderJms.class, args);) {
			JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
			Book book = new LiterutureBook
					(101, "title101", 300, 2016, 200, "publisher1", 
							new String[]{"author8"}, "genre1");
			
			jmsTemplate.convertAndSend("tel_ran_books", book);
		}
	}

}
