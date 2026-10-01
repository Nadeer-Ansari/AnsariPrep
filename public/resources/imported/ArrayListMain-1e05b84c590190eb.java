package collections_framework;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		ArrayList values = new ArrayList();
		values.add("Welcome");
		values.add("Welcome");
		values.add("Hello");
		values.add(100);
		
		for(Object val : values)
			System.out.println(val);
		System.out.println("Size: " + values.size());
		System.out.println("-----------------");
		values.remove(3);
		for(Object val : values)
			System.out.println(val);
		System.out.println("Size: " + values.size());
		
		

	}

}
