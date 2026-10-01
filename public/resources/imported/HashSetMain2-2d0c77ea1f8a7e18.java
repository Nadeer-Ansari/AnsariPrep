package collections_framework;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain2 {

	public static void main(String[] args) {
		Set<Country> countries = new HashSet<>();
		Country ind = new Country();
		Country us = new Country("USA", "Washington");
		Country jpn = new Country("Japan", "Tokyo");
		Country fra = new Country("France", "Paris");
		Country ger = new Country("Germany", "Berlin");
		
		Country ourCountry = new Country();
		Country usa = new Country("USA", "Washington");
		
		countries.add(ind);
		countries.add(us);
		countries.add(jpn);
		countries.add(fra);
		countries.add(ger);
		countries.add(ourCountry);
		countries.add(usa);
		for(Country ctr : countries)
			System.out.println(ctr);
		
		

	}

}



