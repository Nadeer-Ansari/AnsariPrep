package example.spring.rest.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.entities.Restaurant;
import example.spring.rest.exceptions.RestaurantNotFoundException;
import example.spring.rest.services.RestaurantService;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantServiceRef;
	@GetMapping("/restaurants")
	public Collection<Restaurant> retrieveAll(){
		Collection<Restaurant> availableRestaurants =
		restaurantServiceRef.retrieveAll();
		return availableRestaurants;
	}
	
	@GetMapping("/restaurants/{restaurantId}")
	public Restaurant retrieveById(@PathVariable Integer restaurantId) {
		Restaurant foundRestaurant = 
		restaurantServiceRef.retrieveById(restaurantId);
		if(foundRestaurant == null) {
			throw new 
			RestaurantNotFoundException(restaurantId, "Restaurant not found");
		}
		
		return foundRestaurant;
	}
	
	@PostMapping("/restaurants")
	public void create(@RequestBody Restaurant newRestaurant) {
		System.out.println("Restaurant received for creation:");
		System.out.println(newRestaurant);
		restaurantServiceRef.create(newRestaurant);
	}
}










