package collections_framework;

import java.util.ArrayList;
import java.util.List;

public class TypeSafeCollectionMain {

	public static void main(String[] args) {
		List<String> cities = new ArrayList<>();
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Nashik");
		cities.add("Nagpur");
		cities.add("Kolhapur");
		
		for(String city : cities)
			System.out.println(city.toUpperCase());
		
		//List<Employee> employees = new ArrayList<>();
		
		
	}
}





