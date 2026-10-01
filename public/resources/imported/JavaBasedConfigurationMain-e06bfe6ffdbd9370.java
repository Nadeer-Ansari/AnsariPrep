package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBasedConfigurationMain {

	public static void main(String[] args) {
		ApplicationContext context =
		new AnnotationConfigApplicationContext(SpringConfig.class);
		
		//context.register(SpringConfig.class);
		//context.refresh();
		
		Object obj = context.getBean("employee3");
		Object obj2 = context.getBean("employee3");
		Object obj3 = context.getBean("employee3");
		
		System.out.println(obj);
		System.out.println(obj == obj2);
		System.out.println(obj == obj3);

	}

}
