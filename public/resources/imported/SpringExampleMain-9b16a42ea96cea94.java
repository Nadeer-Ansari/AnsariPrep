package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringExampleMain {

	public static void main(String[] args) {
		String configPath = "./src/main/resources/spring-config.xml";
		ApplicationContext context = 
		new FileSystemXmlApplicationContext(configPath);
		
		Object obj = context.getBean("greet");
		GreetingService serviceRef = (GreetingService)obj;
		String reply = serviceRef.sayGreeting();
		System.out.println(reply);
		
		System.out.println("=======================");
		
		GreetingService anotherServiceRef 
		= new HelloService();
		String anotherReply = anotherServiceRef.sayGreeting();
		System.out.println(anotherReply);
		
	}

}






