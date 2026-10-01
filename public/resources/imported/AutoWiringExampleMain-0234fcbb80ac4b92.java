package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoWiringExampleMain {

	public static void main(String[] args) {
		ApplicationContext context =
		new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Object obj = context.getBean("customer");
		System.out.println(obj);

	}

}
