package collections_framework;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		Stack values = new Stack();
		values.add("Welcome to Collections Framework");
		values.add("Hello");
		values.add(new StringBuilder("Java is awesome"));
		int age = 90;
		values.add(age);//values.add(new Integer(age));
		float weight = 87.45f;
		values.add(weight);
		boolean success = true;
		values.add(success);
		
		//Obtaining size of the stack
		int size = values.size();
		System.out.println("Size: " + size);
		
		/*for(int index = 0; index < size; index++) {
			Object obj = values.get(index);
			System.out.println(obj);
		}*/
		for(Object obj : values)
			System.out.println(obj);
		System.out.println("---------------------------");
		values.add(3, "India");
		for(Object obj : values)
			System.out.println(obj);
		System.out.println("---------------------------");
		values.remove(5);
		for(Object obj : values)
			System.out.println(obj);

	}

}
