package example.spring.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends RuntimeException{
	private Integer invalidId;
	public RestaurantNotFoundException
	(Integer invalidId, String errorMessage) {
		super(errorMessage);
		this.invalidId = invalidId;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + " : " + invalidId;
	}
}
