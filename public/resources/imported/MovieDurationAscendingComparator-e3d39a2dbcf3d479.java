package collections_framework;

import java.util.Comparator;

public class MovieDurationAscendingComparator 
implements Comparator<Movie>{

	@Override
	public int compare(Movie movie1, Movie movie2) {
		// This method provides customized sorting algorithm to
		//sort Movie objects based upon their duration in asc order.
		Integer duration1 = movie1.getDuration();
		Integer duration2 = movie2.getDuration();
		int comparison = duration1.compareTo(duration2);
		if(comparison == 0)
			comparison = -1;
		return comparison;
	}

}
