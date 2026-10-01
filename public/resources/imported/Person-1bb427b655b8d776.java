package example.bean;

public class Person {
	private String name;
	private int age;
	private float weight;
	public Person() {
		System.out.println("Inside Person No-Arg Constructor");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		System.out.println("Getting Weight");
		return weight;
	}
	public void setWeight(float weight) {
		System.out.println("Setting Weight");
		this.weight = weight;
	}
}
