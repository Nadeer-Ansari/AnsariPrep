package example.spring.core;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration //Marks this class as a configuration specific class
@ComponentScan(basePackages = {"first", "second", "example"})
public class SpringConfig {
	@Bean //Marks this method as a bean declaration method.
	public Employee getEmployee() {
		Employee empObject = new Employee(123, "Sejal", 65000.23f);
		return empObject;
	}
	
	@Bean("employee2")//Overriding the default ID
	public Employee getAnotherEmployee() {
		Employee empObject = new Employee();
		empObject.setEmpNo(654);
		empObject.setName("Ravi");
		empObject.setSalary(65896.63f);
		return empObject;
	}
	
	@Bean("employee3")
	@Lazy
	@Scope("prototype")
	public Employee getOneMoreEmployee() {
		Employee empObject = new Employee();
		empObject.setEmpNo(7565);
		empObject.setName("Jones");
		empObject.setSalary(57813.63f);
		return empObject;
	}
	
	@Bean
	public List<String> getHobbies(){
		List<String> hobbies = 
		Arrays.asList("Trekking", "Reading", "Gardening");
		return hobbies;
	}
	
	@Bean
	public List<String> getDifferentHobbies(){
		List<String> hobbies = 
		Arrays.asList("Music", "Cricket", "Cooking");
		return hobbies;
	}
	
	@Bean("person")
	public Person getPerson() {
		Person personObj = new Person("Neel", getDifferentHobbies());
		return personObj;
		//personObj.setHobbies(getHobbies());
	}
	
	@Bean("home")
	public Address getHomeAddress() {
		Address homeAddress = new Address("Mumbai", 422011);
		return homeAddress;
	}
	
	@Bean("office")
	//@Primary
	public Address getOfficeAddress() {
		Address officeAddress = new Address("New Delhi", 433003);
		return officeAddress;
	}
	
	@Bean("customer")
	public Customer getCustomer() {
		Customer customerObj = new Customer();
		customerObj.setFirstName("Jatin");
		customerObj.setLastName("Shukla");
		return customerObj;
		//Not setting communicationAddress because it is getting auto wired.
	}
}













