package example.spring.rest.security.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.security.jwt.bean.Book;
import example.spring.rest.security.jwt.bean.JwtService;

import example.spring.rest.security.jwt.bean.User;

@RestController
public class SpringRestSecurityJwtController {
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtService jwtService;
	@GetMapping("/home")
	public String getHome() {
		return "Welcome to Spring Rest Security using JWT";
	}
	
	@GetMapping("/index")
	public String getIndex() {
		return "Index";
	}
	
	@PostMapping("/books")
	public void createBook(@RequestBody Book bookObj) {
		System.out.println("Received Book for insertion: " + bookObj);
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody User currentUser) {
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						currentUser.getUserName(), 
						currentUser.getPassword()
						));
		if(authentication.isAuthenticated())
			return jwtService.generateToken(currentUser.getUserName());
		else
		return null;
	}
	
	
}
