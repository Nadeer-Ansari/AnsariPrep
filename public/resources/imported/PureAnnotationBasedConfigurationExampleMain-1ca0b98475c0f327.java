package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import first.FirstComponent;
import second.SecondComponent;
import second.child.SecondChildComponent;

public class PureAnnotationBasedConfigurationExampleMain {

	public static void main(String[] args) {
		ApplicationContext context =
		new AnnotationConfigApplicationContext(SpringConfig.class);
		
		ManagedComponent mgComp = context.getBean(ManagedComponent.class);
		mgComp.doWork();
		
		FirstComponent firstComp = context.getBean(FirstComponent.class);
		firstComp.doWork();
		
		SecondComponent secondComp = context.getBean(SecondComponent.class);
		secondComp.doWork();
		
		/*SecondChildComponent secondChildComp =
				context.getBean(SecondChildComponent.class);
		secondChildComp.doWork();*/
		Object obj = context.getBean("second_child");
		SecondChildComponent secondChild = (SecondChildComponent)obj;
		secondChild.doWork();
	}

}









