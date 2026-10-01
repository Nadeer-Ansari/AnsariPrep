package utility_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMain {

	public static void main(String[] args) {
		int[] numbers = {65,34,23,76,2};
		Arrays.sort(numbers);
		for(int num : numbers)
			System.out.println(num);
		
		List<String> names = 
				Arrays.asList("Nisha", "Pooja", "Sameer");
		for(String name : names)
			System.out.println(name.toUpperCase());
		
		
	}

}
