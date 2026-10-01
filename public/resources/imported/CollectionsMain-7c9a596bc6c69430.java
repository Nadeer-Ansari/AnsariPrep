package utility_classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMain {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(35,65,78,92,7);
		Collections.sort(integers);
		for(Integer in : integers)
			System.out.println(in);

	}

}
