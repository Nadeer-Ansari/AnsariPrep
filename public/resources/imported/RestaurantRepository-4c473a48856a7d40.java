package example.spring.rest.data.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.rest.data.jpa.entities.Restaurant;
//@Repository is not required because JpaRepository is already a Managed Component
public interface RestaurantRepository 
extends JpaRepository<Restaurant, Integer>{

}
