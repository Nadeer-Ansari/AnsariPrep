package example.spring.rest.controllers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.models.Message;

@RestController
public class SpringRestController {
	@GetMapping("/doGreet")
	public String getGreeting() {
		return "Welcome to Spring REST";//Data
	}
	
	@GetMapping("/doMessage")
	public Message getMessage() {
		Message msg = new Message();
		return msg;
	}
	
	@GetMapping("/doMessages")
	public Collection<Message> getMessages() {
		Message msg = new Message();
		Message msg2 = 
		new Message("Happy Year End", LocalDate.of(2026, 12, 31));
		Message msg3 = 
		new Message("Happy Independence Day", LocalDate.of(2026, 8, 15));
		
		Collection<Message> messages = Arrays.asList(msg, msg2, msg3);
		return messages;
	}
}






