package example.spring.rest.stores;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import example.spring.rest.entities.Restaurant;

public class RestaurantStore {
	private static Map<Integer, Restaurant> allRestaurants;
	static {
		allRestaurants = new HashMap<>();
		Restaurant r1 = new Restaurant();
		Restaurant r2 = 
		new Restaurant(102, "McDonalds", "American", 15);
		Restaurant r3 = 
		new Restaurant(103, "Little Italy", "Italian", 12);
		Restaurant r4 = 
		new Restaurant(104, "Thai Express", "Thai", 8);
		Restaurant r5 = 
		new Restaurant(105, "Mainland China", "Chinese", 5);
		
		allRestaurants.put(r1.getRestaurantId(), r1);
		allRestaurants.put(r2.getRestaurantId(), r2);
		allRestaurants.put(r3.getRestaurantId(), r3);
		allRestaurants.put(r4.getRestaurantId(), r4);
		allRestaurants.put(r5.getRestaurantId(), r5);
	}
	
	public static Collection<Restaurant> retrieveAll(){
		Collection<Restaurant> availableRestaurants = 
		allRestaurants.values();
		return availableRestaurants;
	}
	
	public static Restaurant retrieveById(Integer restaurantId) {
		return allRestaurants.get(restaurantId);
		/*Restaurant foundRestaurant = allRestaurants.get(restaurantId);
		return foundRestaurant;*/
	}
	
	public static void create(Restaurant newRestaurant) {
		allRestaurants.put
		(newRestaurant.getRestaurantId(), newRestaurant);
	}
}











