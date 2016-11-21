package tel_ran.recievers;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
public class RecieverJms {
	
	@Bean
	public MessageConverter createMessageConverter(){
		MappingJackson2MessageConverter res = new MappingJackson2MessageConverter();
		res.setTargetType(MessageType.TEXT);
		res.setTypeIdPropertyName("_type");//type - same in reciever
		return res;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RecieverJms.class, args);
	}

}
