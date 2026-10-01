package collections_framework;

import java.util.ArrayList;
import java.util.List;

public class TypeUnsafeCollectionMain {

	public static void main(String[] args) {
		List cities = new ArrayList();
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Nashik");
		cities.add("Nagpur");
		cities.add("Kolhapur");
		
		for(Object obj : cities) {
			String city = (String)obj;
			System.out.println(city.toUpperCase());			
		}
	}
}





