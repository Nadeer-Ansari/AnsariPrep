package collections_framework;

import java.util.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList values = new LinkedList();
		values.add("Welcome");
		values.add("Welcome");
		values.add("Hello");
		values.add(100);
		
		for(Object val : values)
			System.out.println(val);
		System.out.println("---------------");
		values.addFirst("Good Morning");
		for(Object val : values)
			System.out.println(val);
		System.out.println("First Element: " + values.getFirst());
		System.out.println("Last Element: " + values.getLast());
		System.out.println("---------------");
		values.removeFirst();
		values.removeLast();
		for(Object val : values)
			System.out.println(val);
		

	}

}
