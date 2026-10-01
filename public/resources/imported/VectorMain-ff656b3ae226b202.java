package collections_framework;

import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		Vector values = new Vector();
		System.out.println("Current Size: " + values.size());
		System.out.println("Current capacity: " + values.capacity());
		System.out.println("----------------");
		for(int a=1;a<=10;a++)
			values.add(a);
		System.out.println("Current Size: " + values.size());
		System.out.println("Current capacity: " + values.capacity());
		System.out.println("----------------");
		values.add("Thank you");
		System.out.println("Current Size: " + values.size());
		System.out.println("Current capacity: " + values.capacity());
		
		
	}

}
