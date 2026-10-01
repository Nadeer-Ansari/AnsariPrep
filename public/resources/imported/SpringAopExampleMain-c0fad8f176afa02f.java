package example.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopExampleMain {

	public static void main(String[] args) {
		ApplicationContext context =
		new AnnotationConfigApplicationContext(SpringAopConfig.class);
		
		Musician musicianObj = context.getBean(Musician.class);
		Singer singerObj = context.getBean(Singer.class);
		
		musicianObj.perform();
		System.out.println("===============");
		singerObj.perform();
		System.out.println("Printing object class names:");
		System.out.println(musicianObj.getClass().getName());
		System.out.println(singerObj.getClass().getName());
	}

}








