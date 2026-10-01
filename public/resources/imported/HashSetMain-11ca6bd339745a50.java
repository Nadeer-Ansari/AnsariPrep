package collections_framework;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {

	public static void main(String[] args) {
		Set<String> countries = new HashSet<>();
		countries.add("India");
		countries.add("India");
		countries.add("India");
		countries.add("USA");
		countries.add("Germany");
		countries.add("Japan");
		countries.add("France");
		System.out.println(countries.size());
		for(String country : countries)
			System.out.println(country);

	}

}



