package collections_framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorMain {

	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Mango");
		fruits.add("Apple");
		fruits.add("Grapes");
		fruits.add("Guava");
		fruits.add("Watermelon");
		
		//Obtaining an Iterator on the top of the list: fruits
		Iterator<String> it = fruits.iterator();
		while(it.hasNext()) {
			String fruit = it.next();
			//if(fruit.equals("Guava"))
				//it.remove();
			System.out.println(fruit);
		}
		//System.out.println(fruits.size());
		
	}

}






