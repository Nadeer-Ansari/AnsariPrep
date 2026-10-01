package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependencyInjectionExampleMain {

	public static void main(String[] args) {
		String configFile = "spring-config.xml";
		ApplicationContext context = 
		new ClassPathXmlApplicationContext(configFile);
		
		Object obj = context.getBean("greetUser");
		GreetingService serviceRef = (GreetingService)obj;
		String reply = serviceRef.sayGreeting();
		System.out.println(reply);	
		
		System.out.println("================");
		
		obj = context.getBean("greetUserAgain");
		serviceRef = (GreetingService)obj;
		reply = serviceRef.sayGreeting();
		System.out.println(reply);	
	}
}






