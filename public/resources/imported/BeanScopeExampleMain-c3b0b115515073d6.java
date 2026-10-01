package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeExampleMain {

	public static void main(String[] args) {
		String configFile = "spring-config2.xml";
		ApplicationContext context = 
		new ClassPathXmlApplicationContext(configFile);
		
		Object obj = context.getBean("msg2");
		Object obj2 = context.getBean("msg2");
		Object obj3 = context.getBean("msg2");
		System.out.println(obj == obj2);
		System.out.println(obj == obj3);
		

	}

}







