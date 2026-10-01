package java8_features;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class LambdaExpressionMain2 {

	public static void main(String[] args) {
		/*Comparator<String> descComp = (f1, f2) -> {
			int comparison = f2.compareTo(f1);
			return comparison;
		};*/
		//SortedSet<String> fruits = new TreeSet<>(descComp);
		
		SortedSet<String> fruits = 
				new TreeSet<>((f1, f2) -> f2.compareTo(f1));
		fruits.add("Mango");
		fruits.add("Watermelon");
		fruits.add("Muskmelon");
		fruits.add("Guava");
		fruits.add("Orange");
		
		for(String fruit : fruits)
			System.out.println(fruit);

	}

}
