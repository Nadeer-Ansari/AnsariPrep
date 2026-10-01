package example.spring.rest.data.jpa.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.data.jpa.entities.Restaurant;
import example.spring.rest.data.jpa.services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantServiceRef;
	
	@GetMapping
	public Collection<Restaurant> retrieveAll(){
		return restaurantServiceRef.retrieveAll();
	}
	
	/*@GetMapping("/{restaurantId}")
	public Restaurant retrieveById(@PathVariable Integer restaurantId) {
		Restaurant foundRestaurant = 
		restaurantServiceRef.retrieveById(restaurantId);
		return foundRestaurant;
		
	}*/
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> retrieveById(@PathVariable Integer restaurantId) {
		ResponseEntity<Restaurant> responseEntityRef =
				ResponseEntity.notFound().build();
		
		Restaurant foundRestaurant = 
				restaurantServiceRef.retrieveById(restaurantId);
		if(foundRestaurant != null)
			responseEntityRef = ResponseEntity.ok(foundRestaurant);
		
		return responseEntityRef;		
	}
	
	@PostMapping
	public void create(@RequestBody Restaurant newRestaurant) {
		restaurantServiceRef.create(newRestaurant);
	}
	
	@PutMapping
	public void update(@RequestBody Restaurant modifiedRestaurant) {
		restaurantServiceRef.update(modifiedRestaurant);
	}
	
	@DeleteMapping("/{restaurantId}")
	public void deleteById(@PathVariable Integer restaurantId) {
		restaurantServiceRef.deleteById(restaurantId);
	}
}












