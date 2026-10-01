package collections_framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		Map<String, Float> countryData = new HashMap<>();
		countryData.put("India", 143.32f);
		countryData.put("China", 133.32f);
		countryData.put("Japan", 12.32f);
		countryData.put("USA", 44.45f);
		countryData.put("Australia", 44.45f);
		
		Set<Map.Entry<String, Float>> entries =
		countryData.entrySet();
		
		for(Map.Entry<String, Float> entry : entries) {
			String countryName = entry.getKey();
			Float countryPopulation = entry.getValue();
			System.out.println(countryName + " has a population of " + countryPopulation + " crores.");
		}
		System.out.println("---------------------------");
		
		Set<String> countryNames = countryData.keySet();
		for(String countryName : countryNames) {
			Float countryPopulation = 
			countryData.get(countryName);
			System.out.println(countryName + " has a population of " + countryPopulation + " crores.");
		}
		
		System.out.println("---------------------------");
		Collection<Float> allPopulations = countryData.values();
		for(Float population : allPopulations)
			System.out.println(population);

	}

}
















