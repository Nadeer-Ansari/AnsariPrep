package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLoadingExampleMain {

	public static void main(String[] args) {
		String configFile = "spring-config2.xml";
		ApplicationContext context = 
		new ClassPathXmlApplicationContext(configFile);
		
		//context.getBean("msg2");
		
		

	}

}
