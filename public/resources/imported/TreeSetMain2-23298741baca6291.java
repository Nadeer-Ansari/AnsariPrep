package collections_framework;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMain2 {

	public static void main(String[] args) {
		Comparator<Movie> comp1 = 
		new MovieDurationAscendingComparator();
		
		Comparator<Movie> comp2 = 
		new MovieDurationDescendingComparator();		
		
		SortedSet<Movie> movies = new TreeSet<>(comp1);
		Movie m1 = new Movie("Airlift", 140);
		Movie m2 = new Movie("Dhurandar", 215);
		Movie m3 = new Movie("Dangal", 140);
		Movie m4 = new Movie("Life of PI", 135);
		Movie m5 = new Movie("Sholay", 190);
		
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
		
		for(Movie currentMovie : movies)
			System.out.println(currentMovie);
		

	}

}
