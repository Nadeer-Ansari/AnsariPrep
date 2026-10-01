package example.spring.rest.models;

import java.time.LocalDate;

public class Message {
	private String greeting;
	private LocalDate sendOn;
	public Message() {
		greeting = "Happy New Year";
		sendOn = LocalDate.of(2027, 1, 1);
	}
	public Message(String greeting, LocalDate sendOn) {
		super();
		this.greeting = greeting;
		this.sendOn = sendOn;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public LocalDate getSendOn() {
		return sendOn;
	}
	public void setSendOn(LocalDate sendOn) {
		this.sendOn = sendOn;
	}
	@Override
	public String toString() {
		return "Message [greeting=" + greeting + ", sendOn=" + sendOn + "]";
	}
	
}
