package example.spring.rest.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestSecurityController {
	@GetMapping("/home")//No Security
	public String getHome() {
		return "Welcome to Spring Security";
	}
	
	@GetMapping("/regular")//Authentication
	public String getRegular() {
		return "Regular work is going on";
	}
	
	@GetMapping("/admin")//Authorization
	public String getAdmin() {
		return "Admin work is going on";
	}
}
