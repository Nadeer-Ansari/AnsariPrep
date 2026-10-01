package example.spring.core;

public class UserGreetingService implements GreetingService {
	private String name;//Jimmy
	private String greetingMessage;//Welcome
	private int age;//40
	
	public UserGreetingService() {
		System.out.println("Inside UserGreetingService()");
	}


	public UserGreetingService(String name, String greetingMessage, int age) {
		System.out.println("Inside UserGreetingService(String,String,int)");
		this.name = name;
		this.greetingMessage = greetingMessage;
		this.age = age;
	}


	public UserGreetingService(int age, String greetingMessage, String name) {
		System.out.println("Inside UserGreetingService(int, String, String)");
		this.age = age;
		this.greetingMessage = greetingMessage;
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGreetingMessage() {
		return greetingMessage;
	}


	public void setGreetingMessage(String greetingMessage) {
		this.greetingMessage = greetingMessage;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		System.out.println("Setting Age");
		this.age = age;
	}


	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		String message = 
		greetingMessage + " " + name + ", your age is " + age; 
		return message;
	}
}
