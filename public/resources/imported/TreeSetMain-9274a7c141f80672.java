package collections_framework;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		SortedSet<String> movies = new TreeSet<>();
		movies.add("Fighter");
		movies.add("Dangal");
		movies.add("Runway 34");
		movies.add("Baby");
		movies.add("Rustom");
		movies.add("Airlift");
		
		for(String movie : movies) {
			System.out.println(movie.toUpperCase());
		}
		

	}

}
