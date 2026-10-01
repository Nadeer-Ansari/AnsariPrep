package example.spring.core;

import java.util.List;

public class Person {
	private String name;
	private List<String> hobbies;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, List<String> hobbies) {
		super();
		this.name = name;
		this.hobbies = hobbies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", hobbies=" + hobbies + "]";
	}
	

}
