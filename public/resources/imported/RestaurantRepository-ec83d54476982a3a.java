package example.spring.rest.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import example.spring.rest.entities.Restaurant;
import example.spring.rest.stores.RestaurantStore;
@Repository //Marks this class as a Repository
public class RestaurantRepository {
	public Collection<Restaurant> retrieveAll(){
		Collection<Restaurant> availableRestaurants =
		RestaurantStore.retrieveAll();
		return availableRestaurants;
	}
	public Restaurant retrieveById(Integer restaurantId) {
		return RestaurantStore.retrieveById(restaurantId);
	}
	public void create(Restaurant newRestaurant) {
		RestaurantStore.create(newRestaurant);
	}
	
}








