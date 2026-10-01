package example.spring.rest.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.rest.entities.Restaurant;
import example.spring.rest.repositories.RestaurantRepository;

@Service //Marks this class as a Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepositoryRef;

	public Collection<Restaurant> retrieveAll(){
		Collection<Restaurant> availableRestaurants = 
		restaurantRepositoryRef.retrieveAll();
		return availableRestaurants;
	}
	
	public Restaurant retrieveById(Integer restaurantId) {
		return restaurantRepositoryRef.retrieveById(restaurantId);
	}
	
	public void create(Restaurant newRestaurant) {
		restaurantRepositoryRef.create(newRestaurant);
	}

}








