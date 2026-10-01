package example.spring.boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import components.SpringBootComponent;

@SpringBootApplication(scanBasePackages = {"components"}) //@Configuration, @ComponentScan
public class SpringBootProjectApplication {
	@Bean
	public List<String> names() {
		List<String> absentStudents = 
		Arrays.asList("Keshav","Harshal","Akash","Naresh");
		return absentStudents;
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
		SpringApplication.run(SpringBootProjectApplication.class, args);
		
		Object obj = context.getBean("names");
		List<String> names = (List<String>)obj;
		//names.forEach(System.out::println);
		names.forEach(name -> System.out.println(name));
		
		SpringBootComponent comp = 
			context.getBean(SpringBootComponent.class);
		comp.doWork();
		
	}

}

