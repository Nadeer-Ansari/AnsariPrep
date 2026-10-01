package collections_framework;

import java.util.Stack;

public class StackMain2 {
	public static void main(String[] args) {
		Stack values = new Stack();
		values.add(100);
		values.add(200.5);
		values.add("Good Morning");
		values.add(false);
		values.add(100);
		values.add("Good Morning");
		for(Object val : values)
			System.out.println(val);
		System.out.println("--------------------");
		values.push("Welcome");
		values.push("Hello");
		for(Object val : values)
			System.out.println(val);
		System.out.println("--------------------");
		System.out.println("Size: " + values.size());
		Object poppedObject = values.pop();
		System.out.println("Popped Object: " + poppedObject);
		System.out.println("Size: " + values.size());
		System.out.println("--------------------");
		System.out.println("Size: " + values.size());
		Object peekedObject = values.peek();
		System.out.println("Peeked Object: " + peekedObject);
		System.out.println("Size: " + values.size());
	}
}








