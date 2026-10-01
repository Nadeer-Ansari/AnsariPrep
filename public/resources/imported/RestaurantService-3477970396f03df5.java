package example.spring.rest.data.jpa.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.rest.data.jpa.entities.Restaurant;
import example.spring.rest.data.jpa.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepositoryRef;
	public Collection<Restaurant> retrieveAll(){
		Collection<Restaurant> availableRestaurants = 
		restaurantRepositoryRef.findAll();
		return availableRestaurants;
	}
	
	/*public Restaurant retrieveById(Integer restaurantId) {
		Restaurant foundRestaurant = null;
		
		Optional<Restaurant> opRef = 
		restaurantRepositoryRef.findById(restaurantId);
		if(opRef.isPresent())
			foundRestaurant = opRef.get();
		return foundRestaurant;
	}*/
	
	public Restaurant retrieveById(Integer restaurantId) {
		/*Restaurant foundRestaurant = 
		restaurantRepositoryRef.findById(restaurantId).orElse(null);
		return foundRestaurant;*/
		return restaurantRepositoryRef.
				findById(restaurantId).
				orElse(null);
	}
	
	public void create(Restaurant newRestaurant) {
		restaurantRepositoryRef.save(newRestaurant);
	}
	
	public void update(Restaurant modifiedRestaurant) {
		restaurantRepositoryRef.save(modifiedRestaurant);		
	}
	
	public void deleteById(Integer restaurantId) {
		restaurantRepositoryRef.deleteById(restaurantId);
	}
}







